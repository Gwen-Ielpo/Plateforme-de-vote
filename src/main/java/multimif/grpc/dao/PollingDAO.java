package multimif.grpc.dao;

import multimif.grpc.model.Polling;
import multimif.grpc.model.User;

import java.sql.Timestamp;
import java.util.List;


public interface PollingDAO {

    /**
     * Crée un nouveau scrutin
     * @param title Titre du scrutin
     * @param description Description du scrutin
     * @param creationDate Date de début du scrutin
     * @param endDate Date de fin du scrutin (aucun vote ne sera enregistré après)
     * @param type Type du scrutin (décrit les modalités de vote)
     * @param nbVote Nombre de votes possible (1 si élection classique, plus si
     *               classement par points)
     * @param nbTurn Nombre de tours du scrutin (2 si élection classique, peut
     *               être 1 ou plus encore)
     * @param owner L'utilisateur ayant créé le scrutin
     */
    Polling createPolling(String title, String description, Timestamp creationDate,
                       Timestamp endDate, String type, int nbVote, int nbTurn,
                       User owner);

    /**
     * Récupère un scrutin existant par son identifiant unique
     * @param id L'identifiant unique du scrutin
     * @return {@code null} si aucun scrutin n'a été trouvé, une instance de
     *          {@link Polling} sinon
     */
    Polling getPollingById(long id);

    /**
     * Récupère la liste de tous les scrutins existants
     * @return une {@link List} garantie non-nulle (mais peut être vide)
     */
    List<Polling> getPollings();

    /**
     * Change la description d'un scrutin existant.
     * @param polling Le scrutin à modifier
     * @param newDesc La nouvelle description
     */
    void modifyDescription(Polling polling, String newDesc);

    /**
     * Ferme manuellement un scrutin (toujours visible mais impossible de voter)
     * @param polling Le scrutin à fermer
     */
    void closePolling(Polling polling);

    /**
     * Supprime un scrutin
     * @param id L'identifiant unique du scrutin à supprimer
     */
    void deletePolling(long id);

}
