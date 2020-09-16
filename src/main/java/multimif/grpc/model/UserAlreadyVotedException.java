package multimif.grpc.model;

/**
 * Exception dans le cas où l'utilisateur a déjà voté pour un certain tour
 */
public class UserAlreadyVotedException extends Exception {

    private static final String MSG_FORMAT =
            "L'utilisateur %d a déjà voté pour le tour %d !";

    /**
     * Constructeur (définit le message d'erreur en fonction de
     * {@link #MSG_FORMAT}, {@code user} et {@code turn}).
     * @param user L'utilisateur ayant déjà voté
     * @param turn Le tour dans lequel l'utilisateur a déjà voté
     */
    public UserAlreadyVotedException(User user, Turn turn) {
        super(String.format(MSG_FORMAT, user.getIdUser(), turn.getId()));
    }

}
