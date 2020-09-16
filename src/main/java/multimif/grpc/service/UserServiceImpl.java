package multimif.grpc.service;

import multimif.grpc.dao.UserDAO;
import multimif.grpc.model.User;
import multimif.grpc.crypto.Crypto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public User createUser(String pseudo, String email, String password)  {
        return userDAO.createUser(pseudo,email,password);
    }
    @Transactional
    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Transactional(readOnly =  true)
    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Transactional
    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Transactional
    @Override
    public User getUserByPseudo(String pseudo) {
        return userDAO.getUserByPseudo(pseudo);
    }

    @Transactional
    @Override
    public void deleteUser(int idUser){
        userDAO.deleteUser(idUser);
    }


    @Transactional
    @Override
    public User getUserByCode(String code){

        return userDAO.getUserByCode(code);
    }

    @Transactional
    @Override
    public User authenticate(String id, String password) {
        String hashPwd = Crypto.hash(password);

        User user = getUserByEmail(id);
        if (user != null && user.getPassword().equals(hashPwd)
                && user.getActivated() && !user.getDeleted()) {
            return user;
        }

        user = getUserByPseudo(id);
        if (user != null && user.getPassword().equals(hashPwd)
                && user.getActivated() && !user.getDeleted()) {
            return user;
        }

        return null;

    }

    @Transactional
    @Override
    public void update(User user) {
        userDAO.update(user);
    }


}
