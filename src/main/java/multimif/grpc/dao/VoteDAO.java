package multimif.grpc.dao;

import multimif.grpc.model.Polling;
import multimif.grpc.model.PollingOption;
import multimif.grpc.model.Turn;
import multimif.grpc.model.Vote;

import java.util.List;


public interface VoteDAO {


    /**
     * Créé un nouveau vote
     * @param user l'identifiant du votant
     * @param optionPerPolling les options du scrutin

     * @param points le points attribué
     * @return
     */
    public Vote createVote(String user, PollingOption optionPerPolling, Polling polling, Turn turn, int points);

    /**
     * Récupère la liste des votes fait par un utilisateur
     * @param user
     * @return
     */
    public List<Vote> getVotesByUser(String user);

    /**
     * Récupère la liste des votes fait par scrutin
     * @param polling l'id d'un scrutin
     * @return
     */
    public List<Vote> getVotesByPolling(Polling polling);
}


