package multimif.grpc.service;

import multimif.grpc.model.Polling;
import multimif.grpc.model.Turn;


public interface TurnService {

    public Turn createTurn(Polling polling, int num, int nbVotes, int nbOptions);
    public Turn getTurnById(int idTurn);
}
