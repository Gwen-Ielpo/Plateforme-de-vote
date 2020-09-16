package multimif.grpc.service;

import multimif.grpc.model.Polling;
import multimif.grpc.model.User;

import java.sql.Timestamp;
import java.util.List;


public interface PollingService {

    Polling createPolling(String title, String description, Timestamp creationDate,
                          Timestamp endDate, String type, int nbVote, int nbTurn,
                          User owner);

    Polling getPollingById(long id);

    List<Polling> getPollings();

    List<Polling> getActivePollings();

    List<Polling> getPollingsOwnedBy(User owner);

    void modifyDescription(Polling polling, String newDesc);

    void closePolling(Polling polling);

    void deletePolling(long id);

}
