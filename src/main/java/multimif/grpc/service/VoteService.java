package multimif.grpc.service;

import multimif.grpc.model.Polling;
import java.util.List;

import multimif.grpc.model.PollingOption;
import multimif.grpc.model.Turn;
import multimif.grpc.model.Vote;


public interface VoteService {

    public Vote createVote(String userId, PollingOption optionPerPolling, Polling polling, Turn turn, int points);

    public List<Vote> getVotesByUser(String userId);

    public List<Vote> getVotesByPolling(Polling polling);

}
