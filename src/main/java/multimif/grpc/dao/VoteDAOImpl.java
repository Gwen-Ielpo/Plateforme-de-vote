package multimif.grpc.dao;

import multimif.grpc.model.Polling;
import multimif.grpc.model.PollingOption;
import multimif.grpc.model.Turn;
import multimif.grpc.model.Vote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VoteDAOImpl implements VoteDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Vote createVote(String idUser, PollingOption optionPerPolling, Polling polling, Turn turn, int points) {
        Session session = sessionFactory.getCurrentSession();
        Vote vote = new Vote();
        vote.setHashUser(idUser);
        vote.setOptionPerPolling(optionPerPolling);
        vote.setPolling(polling);
        vote.setTurn(turn);
        vote.setPoints(points);
        session.persist(vote);
        session.flush();
        return vote;
    }

    @Override
    public List<Vote> getVotesByPolling(Polling idPolling) {
        Session session = sessionFactory.getCurrentSession();
        List<Vote> votes;
        try {
            votes = session.createNamedQuery("vote.findByPolling", Vote.class)
                    .setParameter("id_polling", idPolling)
                    .getResultList();
            return votes;
        } catch (NoResultException e) {
            return new ArrayList<>();
        }
    }

    @Override

    public List<Vote> getVotesByUser(String userId)
    {
        Session session = sessionFactory.getCurrentSession();
        List<Vote> votes;
        try {
            votes = session.createNamedQuery("vote.findByHash", Vote.class)
                    .setParameter("hash", userId)
                    .getResultList();
            return votes;
        } catch (NoResultException e) {
            return new ArrayList<>();
        }

    }
}