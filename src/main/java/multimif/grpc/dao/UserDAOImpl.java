package multimif.grpc.dao;

import multimif.grpc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User createUser(String pseudo, String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String uniqueID = UUID.randomUUID().toString();
        User user = new  User();
        boolean testPass = user.setPassword(password);
        user.setPseudo(pseudo);
        user.setEmail(email);
        user.setActivated(false);
        user.setActivationcode(uniqueID);
        user.setModified(timestamp);
        user.setDeleted(false);
        user.setAvatar(null);
        if(testPass){
            session.persist(user);
            session.flush();
            return user;
        }
        return null;
    }

    @Override
    public void addAvatarUser(int idUser, String avatar) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.find(User.class, idUser);
        if (!user.getDeleted()) {
            user.setAvatar(avatar);
            session.persist(user);
            session.flush();
        }
    }

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users;
        try {
            users = session.createNamedQuery("user.findAll", User.class).list();
            return users;
        } catch (NoResultException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public User getUserByPseudo(String pseudo) {
        try {
            Session session = sessionFactory.getCurrentSession();
            return (User) session.createNamedQuery("user.findByPseudo").setParameter("pseudo", pseudo)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        if (email == null) {
            return null;
        }
        try {
            Session session = sessionFactory.getCurrentSession();
            return (User) session.createNamedQuery("user.findByEmail").setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(User.class, id);
    }


    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.find(User.class, id);
        if (user != null && !user.getDeleted()) {
            user.setDeleted(true);
        }
    }

    @Override
    public User getUserByCode(String code){
        if (code == null) {
            return null;
        }
        try {
            Session session = sessionFactory.getCurrentSession();
            return (User) session.createNamedQuery("user.findByCode").setParameter("activationcode", code)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        session.flush();
    }


}