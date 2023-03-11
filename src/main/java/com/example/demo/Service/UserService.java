package com.example.demo.Service;

import com.example.demo.Model.User;

public interface UserService{
     public User UserRegistration(User user);
     public User addUser(User user);
     public Boolean UserAuthentication(String email, String Password);
     public User updateUser(User user , Integer id);


}
