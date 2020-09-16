package multimif.grpc.dao;

import multimif.grpc.model.Polling;
import multimif.grpc.model.Turn;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TurnDAOImpl implements TurnDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Turn createTurn(Polling polling, int num, int nbVotes, int nbOptions) {
        Session session = sessionFactory.getCurrentSession();
        Turn turn = new Turn();
        turn.setNbOptions(nbOptions);
        turn.setNum(num);
        turn.setNbVotes(nbVotes);
        turn.setPolling(polling);
        session.persist(turn);
        session.persist(polling);
        session.flush();
        return turn;
    }

    @Override
    public Turn getTurnById(int idTurn) {
        Session session = sessionFactory.getCurrentSession();
        return  session.find(Turn.class, idTurn);

    }
}
