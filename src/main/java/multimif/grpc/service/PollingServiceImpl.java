package multimif.grpc.service;

import multimif.grpc.dao.PollingDAO;
import multimif.grpc.model.Polling;
import multimif.grpc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PollingServiceImpl implements PollingService {

    @Autowired
    private PollingDAO pollingDao;

    @Transactional
    @Override
    public Polling createPolling(String title, String description,
                                 Timestamp creationDate, Timestamp endDate,
                                 String type, int nbVote, int nbTurn, User owner) {
        if(creationDate == null) {
            throw new IllegalArgumentException("La date de création doit être" +
                    "spécifiée");
        }

        if(endDate != null && creationDate.after(endDate)) {
            throw new IllegalArgumentException("La date de création doit être" +
                    "avant la date de fin");
        }

        return pollingDao.createPolling(title, description, creationDate,
                endDate, type, nbVote, nbTurn, owner);
    }

    @Transactional
    @Override
    public Polling getPollingById(long id) {
        return pollingDao.getPollingById(id);
    }

    @Transactional(readOnly =  true)
    @Override
    public List<Polling> getPollings() {
        return pollingDao.getPollings();
    }

    @Transactional
    @Override
    public List<Polling> getActivePollings() {
        List<Polling> pollings = getPollings();
        return pollings.parallelStream()
                .filter(polling -> !polling.isClosed())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Polling> getPollingsOwnedBy(User owner) {
        if(owner == null) {
            throw new IllegalArgumentException("owner ne doit pas etre null");
        }
        List<Polling> pollings = getPollings();
        return pollings.parallelStream()
                .filter(polling -> owner.equals(polling.getOwner()))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void modifyDescription(Polling polling, String newDesc) {
        pollingDao.modifyDescription(polling, newDesc);
    }

    @Transactional
    @Override
    public void closePolling(Polling polling) {
        pollingDao.closePolling(polling);
    }


    @Transactional
    @Override
    public void deletePolling(long id) {
        pollingDao.deletePolling(id);
    }

}
