package com.ijse.IjsePos.service;

import com.ijse.IjsePos.dto.UserPasswordDTO;
import com.ijse.IjsePos.entity.User;
import com.ijse.IjsePos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
         if (existingUser != null){
             existingUser.setUsername(user.getUsername());
             existingUser.setPassword(user.getPassword());
             return userRepository.save(existingUser);
         }
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User changeUserPassword(Long id, UserPasswordDTO userPasswordDTO) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null){
            existingUser.setPassword(userPasswordDTO.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }
}
