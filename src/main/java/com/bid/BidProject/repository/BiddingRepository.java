package com.bid.BidProject.repository;

import com.bid.BidProject.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BiddingRepository extends JpaRepository<Bid, Integer> {

}
