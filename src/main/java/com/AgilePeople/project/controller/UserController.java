package com.AgilePeople.project.controller;

//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.Register;
import com.AgilePeople.project.entity.User;
import com.AgilePeople.project.pojo.ResponsePojo;
import com.AgilePeople.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<ResponsePojo> createUser(@RequestBody User user){
        String errorMsg = "";
        ResponsePojo responsePojo = null;
        if( user!= null)
        {
            if(user.getFirstName() == null || user.getFirstName().equals("")) {
                errorMsg = "First name is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(user.getLastName() == null || user.getLastName().equals("")) {
                errorMsg = "Last name is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(user.getEmail() == null || user.getEmail().equals("")) {
                errorMsg = "Email is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (!user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else {
                User userData = userService.createUser(user);
                responsePojo = new ResponsePojo();
                responsePojo.setSuccess(true);
                responsePojo.setData(userData);
            }
        }
        return new ResponseEntity<>(responsePojo, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user){
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }
}