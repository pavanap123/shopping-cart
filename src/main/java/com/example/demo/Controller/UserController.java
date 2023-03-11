  package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service.UserService;
import com.example.demo.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;

  @RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
    }
    @PostMapping("/users/add")
    public ResponseEntity<Object> userRegistration(@RequestBody User user) {
        try {
            User u1 = userService.UserRegistration(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (EntityExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("show/{email}/{password}")
    public ResponseEntity<Object> userAuthenticate(@PathVariable("email") String email, @PathVariable("password") String password) {
        boolean result = userService.UserAuthentication(email, password);
        if (result) {
            return new ResponseEntity<>("Login Successful", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Login Unsuccessful", HttpStatus.ACCEPTED);
        }
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user,id));

    }
}

