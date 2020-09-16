package multimif.grpc.model;


import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;


/**
 * Représente un scrutin
 */
@Entity
@Table(schema="election", name="polling")
@NamedQuery(name = "polling.select_all", query = "select p from Polling p")
public class Polling {

    @Id
    @SequenceGenerator(name="polling_seq", schema="election",
            sequenceName="election.polling_id_polling_seq", allocationSize=1,
            initialValue=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="polling_seq")
    @Column(name="id_polling", nullable=false, unique=true)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User owner;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="deleted")
    private Boolean deleted;

    @Column(name="creationdate")
    private Timestamp creationDate;

    @Column(name="enddate")
    private Timestamp endDate;

    @Column(name="type")
    private String type;

    @Column(name="nb_vote")
    private int nbVote;

    @Column(name="nb_turn")
    private int nbTurn;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="id_polling")
    private List<PollingOption> options;

    @OneToMany
    @JoinColumn(name="id_polling")
    private List<Turn> turns;


    public Polling() {
        // Constructeur vide
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNbVote() {
        return nbVote;
    }

    public void setNbVote(int nbVote) {
        this.nbVote = nbVote;
    }

    public int getNbTurn() {
        return nbTurn;
    }

    public void setNbTurn(int nbTurn) {
        this.nbTurn = nbTurn;
    }

    public List<PollingOption> getOptions() {
        return options;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public boolean isClosed() {
        return deleted
                || (endDate != null && endDate.after(Timestamp.from(Instant.now())));
    }

}
