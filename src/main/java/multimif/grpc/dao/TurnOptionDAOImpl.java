package multimif.grpc.dao;

import multimif.grpc.model.Polling;
import multimif.grpc.model.PollingOption;
import multimif.grpc.model.Turn;
import multimif.grpc.model.TurnOption;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class TurnOptionDAOImpl implements TurnOptionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public TurnOption createOption(Polling polling,
            PollingOption pollingOption,
            Turn turn) {
        Session session = sessionFactory.getCurrentSession();

        TurnOption turnOption = new TurnOption();
        turnOption.setPolling(polling);
        turnOption.setPollingOption(pollingOption);
        turnOption.setTurn(turn);

        session.persist(turnOption);
        session.flush();

        return turnOption;

    }

    @Override
    public List<TurnOption> getOptionsForTurn(Turn turn) {
        Session session = sessionFactory.getCurrentSession();
        return session.createNamedQuery("option_per_turn.select_by_turn",
                TurnOption.class)
                .setParameter("turn", turn)
                .getResultList();
    }

}
