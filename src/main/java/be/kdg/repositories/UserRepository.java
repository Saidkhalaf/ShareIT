package be.kdg.repositories;

import be.kdg.domain.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final Map<Long, User> users = new HashMap<>();

    public User getUserById(Long userId) {
        return users.get(userId);
    }

    public User getUserByName(String name) {
        for (User user : users.values()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void updateUser(User user) {
        users.put(user.getId(), user); // Update or add the user in the map
    }

    public List<User> findAllUsers() {
        return new ArrayList<>  (users.values());
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }
    public void updateUserBalance(long userId, int newBalance) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
        user.setSharepoints(user.getSharepoints() + newBalance);
        users.put(userId, user);
    }
}
