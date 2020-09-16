package multimif.grpc.dao;

import multimif.grpc.model.Polling;
import multimif.grpc.model.PollingOption;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PollingOptionDAOImpl implements PollingOptionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public PollingOption createPollingOption(Polling polling, String optionName) {
        Session session = sessionFactory.getCurrentSession();
        PollingOption option = new PollingOption();
        option.setPolling(polling);
        option.setName(optionName);
        session.persist(option);
        return option;
    }

    @Override
    public List<PollingOption> getOptionsForPolling(Polling polling) {
        Session session = sessionFactory.getCurrentSession();
        return session.createNamedQuery(
                "polling_option.select_by_polling", PollingOption.class)
                .setParameter("polling", polling)
                .getResultList();
    }

    @Override
    public void deletePollingOption(long id) {
        Session session = sessionFactory.getCurrentSession();
        PollingOption option = session.find(PollingOption.class, id);
        if(option != null) {
            session.delete(option);
            session.flush();
        }
    }

    @Override
    public PollingOption getPollingOptionById(Long idPollingOption) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(PollingOption.class, idPollingOption);
    }
}
