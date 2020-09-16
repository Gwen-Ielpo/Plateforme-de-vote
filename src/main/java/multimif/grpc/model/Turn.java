package multimif.grpc.model;


import javax.persistence.*;


@Entity
@Table(schema="election", name="\"turn\"")
public class Turn {


    @Id
    @SequenceGenerator(name="turn_seq", schema="election",
            sequenceName="\"turn_id_turn_seq\"", allocationSize=1,
            initialValue=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="turn_seq")
    @Column(name="id_turn", unique=true, nullable=false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_polling")
    private Polling polling;

    @Column(name="num_turn")
    private int num;

    @Column(name="nb_vote")
    private int nbVotes;

    @Column(name="nb_option")
    private int nbOptions;

    public Turn() {
        // Constructeur vide
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Polling getPolling() {
        return polling;
    }
    public void setPolling(Polling polling) {
        this.polling = polling;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getNbVotes() {
        return nbVotes;
    }
    public void setNbVotes(int nbVotes) {
        this.nbVotes = nbVotes;
    }
    public int getNbOptions() {
        return nbOptions;
    }
    public void setNbOptions(int nbOptions) {
        this.nbOptions = nbOptions;
    }

}
