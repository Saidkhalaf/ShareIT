package be.kdg.controllers;

import be.kdg.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import be.kdg.domain.user.User;
import be.kdg.services.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
    }

    public String adjustSharepoints(Long userId, int points) {
        User user = userService.findUserById(userId); // Fetch user by ID
        if (user == null) {
            return "User not found!";
        }
        userService.adjustSharepoints(user, points);
        return "Sharepoints adjusted successfully!";
    }

    public void createUser(long id, String name, String address, String bankAccount, String email, int sharepoints) {
        userService.createUser(id, name, address, bankAccount, email, sharepoints);
        System.out.println("Controller: User " + name + " created via UserService.");
    }

    public User findUserById(Long userId) {
        return userService.findUserById(userId);
    }

    public User findUserByName(String name) {
        return userService.findUserByName(name);
    }

}
