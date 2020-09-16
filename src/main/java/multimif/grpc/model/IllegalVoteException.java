package multimif.grpc.model;

/**
 * Exception représentant un vote "illégal" (e.g. mauvais nombre de points
 * attribués, mauvais nombre de candidats sélectionnés,...)
 */
public class IllegalVoteException extends Exception {

    private static final String MSG_BAD_NUMBER_OPTIONS =
            "Mauvais nombre d'options dans le vote ! Attendu : %d ; Reçu : %d";

    /**
     * Constructeur (définit le message d'erreur à partir de {@code message}.
     */
    public IllegalVoteException(String message) {
        super(message);
    }

    /**
     * Définit le message d'erreur à partir du format
     * {@link #MSG_BAD_NUMBER_OPTIONS} (cas où une tentative de vote est faite
     * avec un mauvais nombre d'options par rapport au type du scrutin ;
     * exemple : plus d'une option dans un scrutin uninominal).
     * @param expected Nombre d'options attendues
     * @param actual Nombre d'options obtenues
     */
    public static IllegalVoteException badNumberOfOptions(int expected,
                                                          int actual) {

        return new IllegalVoteException(String.format(MSG_BAD_NUMBER_OPTIONS,
                expected, actual));

    }

}
