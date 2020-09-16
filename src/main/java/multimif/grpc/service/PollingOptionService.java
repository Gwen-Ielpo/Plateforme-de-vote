package multimif.grpc.service;

import multimif.grpc.model.Polling;
import multimif.grpc.model.PollingOption;

import java.util.List;


public interface PollingOptionService {

    PollingOption createPollingOption(Polling polling, String optionName);

    List<PollingOption> getOptionsForPolling(Polling polling);

    void deletePollingOption(long id);

    public PollingOption getPollingOptionById(Long idPollingOption);

}
