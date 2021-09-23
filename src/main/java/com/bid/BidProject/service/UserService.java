package com.bid.BidProject.service;

import com.bid.BidProject.model.User;
import com.bid.BidProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public User getUser(int id){
        return  userRepo.findById(id);

    }
}
