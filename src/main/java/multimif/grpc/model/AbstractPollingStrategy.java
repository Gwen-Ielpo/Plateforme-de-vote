package multimif.grpc.model;

import multimif.grpc.config.Config;
import multimif.grpc.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public abstract class AbstractPollingStrategy {

    protected static final PollingService pollingService;
    protected static final UserService userService;
    protected static final VoteService voteService;
    protected static final PollingOptionService pollingOptionService;
    protected static final TurnService turnService;
    //protected static final TurnOptionService turnOptionService;

    static {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        pollingService = context.getBean(PollingService.class);
        userService = context.getBean(UserService.class);
        voteService = context.getBean(VoteService.class);
        pollingOptionService = context.getBean(PollingOptionService.class);
        turnService = context.getBean(TurnService.class);
    }


    public abstract Polling createPolling(String title, String desc,
                                          String creationDate, String endDate,
                                          User owner, List<String> optionsName);

    public abstract boolean hasVoted (Turn t, User u );

    public abstract void vote (Turn t, User u, Map<TurnOption,Integer> score)
            throws UserAlreadyVotedException, IllegalVoteException;

    public abstract  List<Result> getTurnResults(Turn t);

    public abstract  Map<Turn,List<Result>> getPollingResults(Polling p);

    public abstract  boolean checkDataConsistency(Polling p);

    public abstract  boolean checkDataConsistency(Turn t);

    public abstract Result checkUserVote(User u, Turn t);


    public static AbstractPollingStrategy getStrategyForType(String type) {
        if(PollingType.FIRST_PAST_THE_POST.shortName.equals(type)) {
            return new FirstPastThePostPollingStrategy();
        }
        throw new IllegalArgumentException("Type de scrutin non trouvé : " + type);
    }

    /**
     * Récupère une date au format dd/mm/yyyy (format français) et la transforme
     * en une date utilisable par Timestamp et Instant (les API Java)
     * @param date Un String représentant une date au format dd/mm/yyyy
     * @return Un String représentant une date au format yyyy-[m]m-[d]d hh:mm:ss[.f...]
     */
    public static String transformDate(String date) {
        if(date == null || date.trim().equals("")) {
            // la date est nulle ou vide (ou remplie d'espaces)
            return null;
        }
        String[] parts = date.split("/");
        if(parts.length != 3) {
            throw new IllegalArgumentException("La date " + date + " n'a pas un" +
                    " format correct");
        }
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];
        return year + '-' + month + '-' + day + " 00:00:00";
    }

    /**
     * Type du scrutin
     * ShortName = valeur "computer-friendly" (pour stocker dans la bdd,
     * transmettre dans un formulaire, comparer,...)
     * LongName = valuer "user-friendly" (pour décrire le type)
     */
    public enum PollingType {
        FIRST_PAST_THE_POST("fptp", "Scrutin Uninominal Majoritaire à 1 tour");


        final String shortName;
        final String longName;

        PollingType(String shortName, String longName) {
            this.shortName = shortName;
            this.longName = longName;
        }
        public String getShortName() {
            return shortName;
        }
        public String getLongName() {
            return longName;
        }
    }

}
