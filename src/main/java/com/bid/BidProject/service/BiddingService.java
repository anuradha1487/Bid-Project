package com.bid.BidProject.service;

import com.bid.BidProject.model.Bid;
import com.bid.BidProject.model.Project;
import com.bid.BidProject.model.User;
import com.bid.BidProject.model.Winner;
import com.bid.BidProject.repository.BiddingRepository;
import com.bid.BidProject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BiddingService {

    @Autowired
    BiddingRepository repo;
    @Autowired
    UserService userService;
    @Autowired
    ProjectService projService;
    Project proj;

    public boolean checkIfBidIsValid(Bid bid){
        int projectId = bid.getProjectId();
        return isDeadlineOverDue(projectId);
    }

    public boolean isDeadlineOverDue(int projId){
        proj = projService.getProject(projId);
        Date projEndDate =   proj.getDatetime();

        Date date = new Date();
        if(projEndDate.compareTo(date) < 0)
            return false;
        return true;
    }

    public void saveInToCache(Map< Integer ,Winner>  projPriceMap, Bid bid){
        int newPrice = calculatePrice(bid);
        User user = userService.getUser(bid.customerId);
        Date deadLine = projService.getProject(bid.projectId).getDatetime();

        if(projPriceMap.get(bid.projectId)!= null){
            int currentPrice = projPriceMap.get(bid.projectId).getPrice();
            if(currentPrice > newPrice) {
                Winner win = new Winner();
                win.setPrice(newPrice);
                win.setWinner(user);
                win.setProjDeadLine(deadLine);

                projPriceMap.put(bid.projectId, win);
            }
        }else{

            Winner win = new Winner();
            win.setWinner(user);
            win.setPrice(newPrice);
            win.setProjDeadLine(deadLine);
            projPriceMap.put(bid.projectId, win);
        }
    }
    public int calculatePrice(Bid bid){
        int price;
        if(bid.bidType.equals("Hourly")){
            int totalHours = proj.getTotalHours();
            price = totalHours*bid.getPrice();
        }else{
            price = bid.price;;
        }
        return price;
    }

    public List<Bid> getAllBid(){
        return repo.findAll();
    }


}
