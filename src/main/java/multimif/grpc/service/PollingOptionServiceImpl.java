package multimif.grpc.service;

import multimif.grpc.dao.PollingOptionDAO;
import multimif.grpc.model.Polling;
import multimif.grpc.model.PollingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PollingOptionServiceImpl implements PollingOptionService {

    @Autowired
    private PollingOptionDAO pollingOptionDAO;

    @Transactional
    @Override
    public PollingOption getPollingOptionById(Long idPollingOption){
        return pollingOptionDAO.getPollingOptionById(idPollingOption);
    }


    @Transactional
    @Override
    public PollingOption createPollingOption(Polling polling, String optionName) {
        if(polling == null) {
            throw new IllegalArgumentException("polling ne doit pas etre null");
        }
        return pollingOptionDAO.createPollingOption(polling, optionName);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PollingOption> getOptionsForPolling(Polling polling) {
        if(polling == null) {
            throw new IllegalArgumentException("polling ne doit pas etre null");
        }
        return pollingOptionDAO.getOptionsForPolling(polling);
    }

    @Override
    public void deletePollingOption(long id) {
        pollingOptionDAO.deletePollingOption(id);
    }
}
