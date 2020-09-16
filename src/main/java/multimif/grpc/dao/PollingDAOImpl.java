package multimif.grpc.dao;

import multimif.grpc.model.Polling;
import multimif.grpc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Repository
public class PollingDAOImpl implements PollingDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Polling createPolling(String title, String description,
                              Timestamp creationDate, Timestamp endDate,
                              String type, int nbVote, int nbTurn, User owner) {
        Session session = sessionFactory.getCurrentSession();
        Polling polling = new Polling();
        polling.setTitle(title);
        polling.setDescription(description);
        polling.setDeleted(false);
        polling.setCreationDate(creationDate);
        polling.setEndDate(endDate);
        polling.setType(type);
        polling.setNbVote(nbVote);
        polling.setNbTurn(nbTurn);
        polling.setOwner(owner);

        session.persist(polling);
        return polling;
    }

    @Override
    public Polling getPollingById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Polling.class, id);
    }

    @Override
    public List<Polling> getPollings() {
        Session session = sessionFactory.getCurrentSession();
        return session.createNamedQuery("polling.select_all",
                Polling.class).getResultList();
    }

    @Override
    public void modifyDescription(Polling polling, String newDesc) {
        Session session = sessionFactory.getCurrentSession();
        polling.setDescription(newDesc);
        session.update(polling);
    }

    @Override
    public void closePolling(Polling polling) {
        Session session = sessionFactory.getCurrentSession();
        polling.setEndDate(Timestamp.from(Instant.now()));
        session.update(polling);
    }

    @Override
    public void deletePolling(long id) {
        Session session = sessionFactory.getCurrentSession();
        Polling polling = session.find(Polling.class, id);
        if(polling != null) {
            session.delete(polling);
        }
    }
}
