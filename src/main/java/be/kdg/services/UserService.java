package be.kdg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.kdg.domain.user.User;
import be.kdg.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long userId) {
        return userRepository.getUserById(userId);
    }

    public User findUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    public void adjustSharepoints(User user, int points) {
        user.setSharepoints(user.getSharepoints() + points);
        userRepository.updateUser(user);
    }

    public void createUser(long id, String name, String address, String bankAccount, String email, int sharepoints) {
        User user = new User(id, name, address, bankAccount, email, null, sharepoints);
        userRepository.addUser(user);
        System.out.println("Service: User " + name + " created and added to repository.");
    }
}
