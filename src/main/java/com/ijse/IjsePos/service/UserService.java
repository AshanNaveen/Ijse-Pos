package com.ijse.IjsePos.service;

import com.ijse.IjsePos.dto.UserPasswordDTO;
import com.ijse.IjsePos.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    User updateUser(Long id,User user);
    User getUserById(Long id);
    User changeUserPassword(Long id, UserPasswordDTO userPasswordDTO);
}
