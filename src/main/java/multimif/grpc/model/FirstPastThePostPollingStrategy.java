package multimif.grpc.model;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Stratégie pour le "scrutin uninominal majoritaire à un tour"
 * N candidats, 1 seul tour, 1 seul vote par personne
 * Le gagnant est le candidat avec le plus de votes.
 */
public class FirstPastThePostPollingStrategy extends AbstractPollingStrategy {

    private static final String TYPE = PollingType.FIRST_PAST_THE_POST.getShortName();

    public Polling createPolling(String title, String desc,
                                 String creationDate, String endDate,
                                 User owner, List<String> optionsName) {

        // si la date de création est nulle, on prend l'instant actuel
        String transformedDate = transformDate(creationDate);
        Timestamp timeCreationDate = (transformedDate != null) ?
                Timestamp.valueOf(transformedDate) :
                Timestamp.from(Instant.now());

        // si la date de fin est nulle, on garde nulle pour signifier indéterminée
        transformedDate = transformDate(endDate);
        Timestamp timeEndDate = (transformedDate != null) ?
                Timestamp.valueOf(transformedDate) :
                null;

        // création du scrutin
        Polling polling = pollingService.createPolling(title, desc, timeCreationDate,
                timeEndDate, TYPE, 1, 1, owner);
        // création des options pour ce scrutin
        optionsName.forEach(name ->
            pollingOptionService.createPollingOption(polling, name)
        );
        // création du tour
        Turn turn = turnService.createTurn(polling, 1, 1,
                optionsName.size());
        // création des options pour ce tour
        optionsName.forEach(name -> {});

        return polling;
    }

    @Override
    public boolean hasVoted(Turn t, User u) {
        List<Vote> votes = voteService.getVotesByUser(
                String.valueOf(u.getIdUser()));
        for(Vote v : votes) {
            if(v.getTurn().equals(t)) {
                // l'utilisateur a un vote dans le tour t
                return true;
            }
        }
        return false;
    }

    @Override
    public void vote(Turn t, User u, Map<TurnOption, Integer> score)
            throws UserAlreadyVotedException, IllegalVoteException {

        if(hasVoted(t,u)) {
            // l'utilisateur a deja vote
            throw new UserAlreadyVotedException(u, t);
        }

        if(score.size() != 1) {
            // l'utilisateur essaie de voter pour plus d'1 candidat
            throw IllegalVoteException.badNumberOfOptions(1, score.size());
        }

        score.forEach((option,points) ->
            // bien qu'on utilise un foreach, il ne devrait y avoir qu'un seul
            // couple <option,points> (size == 1)
            voteService.createVote(
                    String.valueOf(u.getIdUser()),
                    option.getPollingOption(),
                    option.getPolling(),
                    option.getTurn(),
                    points)
        );

    }

    @Override
    public List<Result> getTurnResults(Turn t) {
        List<Result> list = new ArrayList<>();
        // TODO: utiliser le DAO turn option
        return list;
    }

    @Override
    public Map<Turn, List<Result>> getPollingResults(Polling p) {
        return null;
    }

    @Override
    public boolean checkDataConsistency(Polling p) {
        return true;
    }

    @Override
    public boolean checkDataConsistency(Turn t) {
        return true;
    }

    @Override
    public Result checkUserVote(User u, Turn t) {
        Result result = null;
        List<Vote> votes = voteService.getVotesByUser(
                String.valueOf(u.getIdUser()));
        for(Vote vote : votes) {
            if(vote.getTurn().equals(t)) {
                TurnOption option = null;
                // FIXME: recuperer option via vote.getId_option_per_polling
                result = new ResultInt(option, vote.getPoints());
                break;
            }
        }
        return result;
    }
}
