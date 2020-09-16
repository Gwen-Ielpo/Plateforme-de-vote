package multimif.grpc.model;

import multimif.grpc.crypto.Crypto;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;

@Entity
@Table(schema="election", name="user")
@NamedQueries({
        @NamedQuery(name="user.findAll", query="SELECT u FROM User u where u.deleted=false"),
        @NamedQuery(name="user.findByEmail", query="SELECT u FROM User u where u.email = :email and u.deleted=false") ,
        @NamedQuery(name="user.findByPseudo", query="SELECT u FROM User u where u.pseudo = :pseudo and u.deleted=false"),
        @NamedQuery(name="user.findByCode", query="SELECT u FROM User u where u.activationcode = :activationcode and u.deleted=false")
})

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="user_seq", schema="election",
            sequenceName="\"user_id_user_seq\"", allocationSize=1,
            initialValue=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")
    @Column(name="id_user", nullable=false, unique=true)
    private int idUser;

    @Column(name="pseudo")
  private String pseudo;

  @Column(name="email")
  private String email;

  @Column(name="firstname")
  private String firstname;

 @Column(name="lastname")
  private String lastname;

  @Column(name="birthday")
  private java.sql.Date birthday;

  @Column(name="deleted")
  private boolean deleted;

  @Column(name="modified")
  private java.sql.Timestamp modified;

  @Column(name="activationcode")
  private String activationcode;

  @Column(name="activated")
  private boolean activated;

  @Column(name="avatar")
  private String avatar;

  @Column(name="password")
  private String password;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_user")
  private List<Polling> ownPollings ;



  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public String getPseudo() {
    return pseudo;
  }

  public void setPseudo(String pseudo) {
    this.pseudo = pseudo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public java.sql.Date getBirthday() {
    return birthday;
  }

  public void setBirthday(java.sql.Date birthday) {
    this.birthday = birthday;
  }

  public boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  public java.sql.Timestamp getModified() {
    return modified;
  }

  public void setModified(java.sql.Timestamp modified) {
    this.modified = modified;
  }

  public String getActivationcode() {
    return activationcode;
  }

  public void setActivationcode(String activationcode) {
    this.activationcode = activationcode;
  }

  public boolean getActivated() {
    return activated;
  }

  public void setActivated(boolean activated) {
    this.activated = activated;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getPassword() {
    return password;
  }

  public boolean setPassword(String password) {
      String passwordHash;
      passwordHash = Crypto.hash(password);
      if(passwordHash != null){
          this.password = passwordHash;
          return true;
      }
      return false;
  }

    public List<Polling> getOwnPollings() {
        return ownPollings;
    }

    public void setOwnPollings(List<Polling> ownPollings) {
        this.ownPollings = ownPollings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != user.idUser) return false;
        if (!pseudo.equals(user.pseudo)) return false;
        if (!email.equals(user.email)) return false;
        return activationcode.equals(user.activationcode);
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + pseudo.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + activationcode.hashCode();
        return result;
    }

}
