package multimif.grpc.service;

import multimif.grpc.dao.TurnDAO;
import multimif.grpc.model.Polling;
import multimif.grpc.model.Turn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TurnServiceImpl implements TurnService {

    @Autowired
    private TurnDAO turnDAO;

    @Transactional
    @Override
    public Turn createTurn(Polling polling, int num, int nbVotes, int nbOptions) {
      return turnDAO.createTurn(polling,num,nbVotes,nbOptions);
    }

    @Transactional
    @Override
    public Turn getTurnById(int idTurn) {
        return turnDAO.getTurnById(idTurn);
    }
}
