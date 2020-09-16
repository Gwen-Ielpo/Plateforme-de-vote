package multimif.grpc.model;

import javax.persistence.*;


/**
 * Représente une option de scrutin. Ces options sont ensuite réparties dans
 * les différents tours.
 * @see Polling
 */
@Entity
@Table(schema="election", name="option_per_polling")
@NamedQueries({
        @NamedQuery(name = "polling_option.select_by_polling", query =
                    "select o from PollingOption o where o.polling = :polling")
})
public class PollingOption {

    @Id
    @SequenceGenerator(name="option_polling_seq", schema="election",
            sequenceName="election.option_per_polling_id_option_per_polling_seq",
            allocationSize=1, initialValue=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="option_polling_seq")
    @Column(name="id_option_per_polling", unique=true, nullable=false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_polling")
    private Polling polling;

    @Column(name="title_option")
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
