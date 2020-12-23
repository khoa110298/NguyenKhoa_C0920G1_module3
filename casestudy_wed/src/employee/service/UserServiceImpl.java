package employee.service;

import employee.model.User;
import employee.repository.UserRepository;
import employee.repository.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }
}
