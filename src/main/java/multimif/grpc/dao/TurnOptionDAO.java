package multimif.grpc.dao;

import multimif.grpc.model.Polling;
import multimif.grpc.model.PollingOption;
import multimif.grpc.model.Turn;
import multimif.grpc.model.TurnOption;

import java.util.List;


public interface TurnOptionDAO {

    TurnOption createOption(Polling polling,
                            PollingOption pollingOption,
                            Turn turn);

    List<TurnOption> getOptionsForTurn(Turn turn);

}
