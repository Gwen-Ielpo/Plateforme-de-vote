package multimif.grpc.service;

import multimif.grpc.model.User;

import java.util.List;

public interface UserService {

 User createUser(String pseudo,String email,String password) ;

 public User getUserById(int id);
 public List<User> getUsers();
 public User getUserByEmail(String email);
 public User getUserByPseudo(String pseudo);
 public void deleteUser(int id);
 public User getUserByCode(String code);

 User authenticate(String id, String password);


    void update(User user);
}
