package com.ijse.IjsePos.controller;

import com.ijse.IjsePos.dto.UserPasswordDTO;
import com.ijse.IjsePos.entity.User;
import com.ijse.IjsePos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return (user != null ? ResponseEntity.status(HttpStatus.OK).body(user)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PutMapping("/users/{id}/change-password")
    public ResponseEntity<User> changePassword(@PathVariable Long id, @RequestBody UserPasswordDTO userPasswordDTO) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.changeUserPassword(id, userPasswordDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
