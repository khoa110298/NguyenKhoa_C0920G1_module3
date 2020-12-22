package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    List<User> selectAllUser();

    User selectUserById(int id);

    void insertUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);

    List<User> selectUserByCountry(String country);

    List<User> sortListUserByName();

    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user, int[] permision);

    void insertUpdateWithoutTransaction();

    void insertUpdateUseTransaction();

    List<User> selectAllUserStore();

    void updateUserStore(User user);

    void deleteUserStore(int id);
}
