package com.hqlcrud.CrudOperationsUsingHql.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hqlcrud.CrudOperationsUsingHql.Entities.UserEntity;
import com.hqlcrud.CrudOperationsUsingHql.Service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService service;

    // Add User
    @PostMapping("/addUser")
    public String addUser(@RequestBody UserEntity user) {
        service.saveUser(user);
        return "User added successfully";
    }

    // Update User
    @PutMapping("/updateUser")
    public String updateUser(@RequestBody UserEntity user) {
        service.updateUser(user.getId(), user.getName(), user.getEmail());
        return "User updated successfully";
    }

    // Delete User by ID
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }

    // Get all Users
    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers() {
        return service.getAllUsers();
    }

    // Get a specific User by ID
    @GetMapping("/getUser/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }
}
