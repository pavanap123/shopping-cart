package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;



    @Override
    public User UserRegistration(User user) {
        User u1=userRepo.findByemail(user.getEmail());
        if (u1==null){
            userRepo.save(user);
            return user;
        }else {
            throw new EntityExistsException("email id already exits");
        }
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Boolean UserAuthentication(String email, String Password) {
       User u1 = userRepo.findByemail(email);
        return u1.getPassword().equals(Password);
    }

    @Override
    public User updateUser(User user, Integer id) {
       User u1 = userRepo.findById(id).orElseThrow(
               () -> new RuntimeException("fsdfs"));

       u1.setName(Objects.isNull(user.getName())? u1.getName() : user.getName());
       u1.setEmail(Objects.isNull(user.getEmail())?u1.getEmail():user.getEmail());
       u1.setPassword(Objects.isNull(user.getPassword())?u1.getPassword():user.getPassword());
       u1.setAccountStatus(Objects.isNull(user.getAccountStatus())?u1.getAccountStatus():user.getAccountStatus());
        return userRepo.save(u1);
    }
//
//    @Override
//    public Boolean UserAuthentication(String email, String Password) {
//        User u1=userRepo.findByemail(email);
//
//        return u1.getPassword().equals(Password);
//    }
}




