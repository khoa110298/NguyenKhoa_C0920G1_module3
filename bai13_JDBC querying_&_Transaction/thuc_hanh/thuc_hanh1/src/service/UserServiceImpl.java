package service;

import model.User;
import repository.UserReposiory;
import repository.UserReposioryImpl;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserReposiory userReposiory = new UserReposioryImpl();
    @Override
    public void insertUser(User user) throws SQLException {
        userReposiory.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userReposiory.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userReposiory.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userReposiory.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userReposiory.updateUser(user);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userReposiory.findUserByName(name);
    }
}
