package com.bid.BidProject.controller;

import com.bid.BidProject.model.Bid;
import com.bid.BidProject.model.Project;
import com.bid.BidProject.model.Winner;
import com.bid.BidProject.repository.BiddingRepository;
import com.bid.BidProject.service.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/bid")
public class BiddingController {

    @Autowired
    private BiddingRepository biddingRepo;
    @Autowired
    BiddingService bidService;
    Map<Integer, Winner> projPriceMap = new HashMap<>();

    @GetMapping(value = "/getBid/{id}")
    public Bid getBid(@PathVariable int id){
        System.out.println("this is Bid-projectBranch-2222222");
        System.out.println("this is master branch commit 1");
       return  biddingRepo.getById(id);

    }
    @GetMapping(value = "/getBidAll")
    public List<Bid> getBid(){
        System.out.println("this is branch 1");
        System.out.println("this is a test message to check mrege conflict");

        return  biddingRepo.findAll();

    }

    @PostMapping(value = "/postBid")
    public String postBid(@RequestBody Bid bid){
       if( !bidService.checkIfBidIsValid(bid))
           return "Bid is not valid";
       biddingRepo.save(bid);
        bidService.saveInToCache(projPriceMap, bid);
        return "success";

    }

    @GetMapping(value = "/getWinner/{id}")
    public Winner getWinner(@PathVariable int id){
        if(bidService.isDeadlineOverDue(id))
        return projPriceMap.get(id);
        else {
            System.out.println("Project DeadLine is not reached");
            return null;
        }

    }
    //scheduler in every 30 min 1800000
//    @Scheduled(fixedDelay = 5000)
//    public void showWinner(){
//        List<Winner> winnerList = new ArrayList<>();
//        winnerList = projPriceMap.values().stream().
//                filter(x -> x.getProjDeadLine().compareTo(new Date()) < 0).collect(Collectors.toList());
//
//        winnerList.forEach(x -> System.out.println(x));
//
//
//    }



}
