package multimif.grpc.model;

import java.io.Serializable;

public class VotePK implements Serializable {

    private String hashIdUser;
    private PollingOption idOptionPerPolling;
    private Polling idPolling;
    private Turn idTurn;

    public VotePK() {
        // Constructeur vide
    }

    public VotePK(String hashIdUser, PollingOption idOptionPerPolling, Polling idPolling, Turn idTurn) {
        this.hashIdUser = hashIdUser;
        this.idOptionPerPolling = idOptionPerPolling;
        this.idPolling = idPolling;
        this.idTurn = idTurn;
    }

    public String getHashIdUser() {
        return hashIdUser;
    }

    public void setHashIdUser(String hashIdUser) {
        this.hashIdUser = hashIdUser;
    }

    public PollingOption getIdOptionPerPolling() {
        return idOptionPerPolling;
    }

    public void setIdOptionPerPolling(PollingOption idOptionPerPolling) {
        this.idOptionPerPolling = idOptionPerPolling;
    }

    public Polling getIdPolling() {
        return idPolling;
    }

    public void setIdPolling(Polling idPolling) {
        this.idPolling = idPolling;
    }

    public Turn getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(Turn idTurn) {
        this.idTurn = idTurn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotePK votePK = (VotePK) o;

        return (hashIdUser != null ? hashIdUser.equals(votePK.hashIdUser) : votePK.hashIdUser == null) &&
                (idOptionPerPolling != null ? idOptionPerPolling.equals(votePK.idOptionPerPolling) :
                        votePK.idOptionPerPolling == null) && (idPolling != null ?
                idPolling.equals(votePK.idPolling) : votePK.idPolling == null) &&
                (idTurn != null ? idTurn.equals(votePK.idTurn) : votePK.idTurn == null);
    }

    @Override
    public int hashCode() {
        int result = hashIdUser != null ? hashIdUser.hashCode() : 0;
        result = 31 * result + (idOptionPerPolling != null ? idOptionPerPolling.hashCode() : 0);
        result = 31 * result + (idPolling != null ? idPolling.hashCode() : 0);
        result = 31 * result + (idTurn != null ? idTurn.hashCode() : 0);
        return result;
    }

}
