package com.bid.BidProject.controller;

import com.bid.BidProject.model.User;
import com.bid.BidProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepo;
    @PostMapping(value = "/registerUser")
    public  String registerUser(@RequestBody User user){

        userRepo.save(user);
        return "user saved";
    }

    @GetMapping(value = "/getUser/{name}")
    public User getUserByName(@PathVariable String name){


       return  userRepo.findByName(name);

    }
}
