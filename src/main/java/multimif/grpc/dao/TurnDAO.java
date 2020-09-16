package multimif.grpc.dao;

import multimif.grpc.model.Polling;
import multimif.grpc.model.Turn;


public interface TurnDAO {

    /**
     * Crée un nouveau utilisateur
     * @param polling
     * @param num
     * @param nbVotes
     * @param nbOptions
     *
     * @return Turn
     */
     public Turn createTurn(Polling polling, int num, int nbVotes, int nbOptions);

    /**
     * Crée un nouveau utilisateur
     * @param idTurn
     * @return Turn
     */
     public Turn getTurnById(int idTurn);

}
