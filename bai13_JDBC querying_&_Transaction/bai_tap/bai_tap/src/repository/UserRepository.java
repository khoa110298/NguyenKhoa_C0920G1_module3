package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    List<User> printListUser();

    User findUserById(int id);

    void createNewUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);

    List<User> findUserByCountry(String country);

    List<User> sortListUserByName();

    public void addUserTransaction(User user, int[] permision);

    public void insertUpdateWithoutTransaction();

    public void insertUpdateUseTransaction();

    List<User> selectAllUserStore();

    void updateUserStore(User user);

    void deleteUserStore(int id);
}
