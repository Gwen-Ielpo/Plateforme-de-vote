package multimif.grpc.dao;

import multimif.grpc.model.User;

import java.util.List;

public interface UserDAO {


    /**
     * Crée un nouveau utilisateur
     * @param pseudo le pseudo unique de l'utilisateur
     * @param email  email unique de l'utilisateur
     *   @param email  email unique de l'utilisateur
     * @param password mot de passe de l'utilisateur

     */
    User createUser(String pseudo, String email, String password);

    /**
     * ajoute le nom du fichier de l'avatar de l'utilisateur a la bd
     @param avatar le nom du fichier representant l'avatar de l'utilisateur
     @param idUser l'utilisateur
     */

    public void  addAvatarUser(int idUser, String avatar);

    /**
     * Récupère la liste de tous les utilisaterus existants
     * @return une {@link List} garantie non-nulle (mais peut être vide)
     */
    public List<User> getUsers();


    /**
     * Récupère un utilisateur existant par son pseudo supposé unique
     * @param pseudo L'identifiant unique de l'utilisateur
     * @return {@code null} si aucun utilisateur n'a été trouvé, une instance de
     *          {@link User} sinon
     */
    public User getUserByPseudo(String pseudo);

    /**
     * Récupère un utilisateur existant par son email supposé unique
     * @param email L'identifiant unique de l'utilisateur
     * @return {@code null} si aucun utilisateur n'a été trouvé, une instance de
     *          {@link User} sinon
     */
    public User getUserByEmail(String email);


    /**
     * Récupère un utilisateur existant par son identifiant unique
     * @param id L'identifiant unique de l'utilisateur
     * @return {@code null} si aucun utilisateur n'a été trouvé, une instance de
     *          {@link User} sinon
     */
    public User getUserById(int id);

    /**
     * Supprime un utilisateur
     * @param id L'identifiant unique de l'utilisateur unique  à supprimer
     */
    public void deleteUser(int id);

    public User getUserByCode(String code);

    public void  update(User user);
}
