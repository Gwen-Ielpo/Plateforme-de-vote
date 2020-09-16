package multimif.grpc.model;
import multimif.grpc.crypto.Crypto;

import javax.persistence.*;


@Entity
@IdClass(VotePK.class)
@Table(schema="election", name="vote")
@NamedQueries({
        @NamedQuery(name="vote.findByHash", query="FROM Vote v where v.hash_id_user = :hash"),
        @NamedQuery(name="vote.findByPolling", query="FROM Vote v where v.id_polling = :id_polling")

})

public class Vote {

    @Id
    private String hashUser;
    @Id
    private PollingOption optionPerPolling;
    @Id
    private Polling polling;
    @Id
    private Turn turn;


    private int points;
    public String getHashUser() {
        return hashUser;
    }


    public void setHashUser(String hashUser) {
        this.hashUser = Crypto.hash(hashUser);
    }

    public PollingOption getOptionPerPolling() {
        return optionPerPolling;
    }

    public void setOptionPerPolling(PollingOption optionPerPolling) {
        this.optionPerPolling = optionPerPolling;
    }

    public Polling getPolling() {
        return polling;
    }

    public void setPolling(Polling polling) {
        this.polling = polling;
    }

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
