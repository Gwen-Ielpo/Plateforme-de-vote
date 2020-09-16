package multimif.grpc.model;

import javax.persistence.*;


@Entity
@Table(schema = "election", name = "option_per_turn")
@NamedQuery(name = "option_per_turn.select_by_turn", query =
        "select o from TurnOption o where o.turn = :turn")
public class TurnOption {

    @Id
    private Long id;
    private Polling polling;
    private PollingOption pollingOption;
    private Turn turn;

    public Long getId() {
        return id;
    }

    public Polling getPolling() {
        return polling;
    }

    public PollingOption getPollingOption() {
        return pollingOption;
    }

    public Turn getTurn() {
        return turn;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPolling(Polling polling) {
        this.polling = polling;
    }

    public void setPollingOption(PollingOption pollingOption) {
        this.pollingOption = pollingOption;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }


}
