package com.bid.BidProject.repository;

import com.bid.BidProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository  extends JpaRepository<User, Integer> {
    User findByName(String name);
    User findById(int id);
}
