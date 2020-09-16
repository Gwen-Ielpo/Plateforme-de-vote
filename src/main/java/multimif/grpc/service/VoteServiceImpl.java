package multimif.grpc.service;

import multimif.grpc.dao.VoteDAO;
import multimif.grpc.model.Polling;
import multimif.grpc.model.PollingOption;
import multimif.grpc.model.Turn;
import multimif.grpc.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteDAO voteDAO;

    @Transactional
    @Override
    public Vote createVote(String userId, PollingOption optionPerPolling, Polling polling, Turn turn, int points)
    {
        return voteDAO.createVote(userId, optionPerPolling, polling, turn, points);
    }

    @Transactional
    @Override
    public List<Vote> getVotesByUser(String userId)
    {
        return voteDAO.getVotesByUser(userId);
    }


    @Transactional
    @Override
    public List<Vote> getVotesByPolling(Polling idPolling)
    {
        return voteDAO.getVotesByPolling(idPolling);
    }


}
