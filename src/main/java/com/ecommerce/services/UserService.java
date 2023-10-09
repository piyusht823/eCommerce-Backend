package com.ecommerce.services;

import com.ecommerce.models.User;
import com.ecommerce.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null; // User with the given ID not found
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    
    // Authenticate a user based on username and password
    public User authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            // Authentication successful
            return user;
        }

        // Authentication failed
        return null;
    }
}
