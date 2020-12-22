package service;

import dao.IUserDAO;
import dao.UserDAO;
import model.User;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService implements UserRepository {
    IUserDAO userDAO = new UserDAO();

    @Override
    public List<User> printListUser() {
        return userDAO.selectAllUser();
    }

    @Override
    public User findUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void createNewUser(User user) {
        try {
            userDAO.insertUserStore(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(int id, User user) {
        userDAO.updateUser(id, user);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Override
    public List<User> findUserByCountry(String country) {
        return userDAO.selectUserByCountry(country);
    }

    @Override
    public List<User> sortListUserByName() {
        return userDAO.sortListUserByName();
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        userDAO.addUserTransaction(user,permision);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        userDAO.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {
        userDAO.insertUpdateUseTransaction();
    }

    @Override
    public List<User> selectAllUserStore() {
        return userDAO.selectAllUserStore();
    }

    @Override
    public void updateUserStore(User user) {
         userDAO.updateUserStore(user);
    }

    @Override
    public void deleteUserStore(int id) {
        userDAO.deleteUserStore(id);
    }


}
