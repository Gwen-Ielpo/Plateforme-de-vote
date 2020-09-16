package multimif.grpc.dao;

import multimif.grpc.model.Polling;
import multimif.grpc.model.PollingOption;

import java.util.List;


public interface PollingOptionDAO {

    PollingOption createPollingOption(Polling polling, String optionName);

    List<PollingOption> getOptionsForPolling(Polling polling);

    void deletePollingOption(long id);

    PollingOption getPollingOptionById(Long idPollingOption);
}
