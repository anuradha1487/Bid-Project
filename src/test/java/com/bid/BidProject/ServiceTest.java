package com.bid.BidProject;

import com.bid.BidProject.model.Bid;
import com.bid.BidProject.repository.BiddingRepository;
import com.bid.BidProject.service.BiddingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    BiddingService biddingSer;

    private MockMvc mvc;
    @MockBean
    BiddingRepository biddingRepo;

//    @Test
//    public void getBiddingListTest(){
//        List<Bid> list = new ArrayList<Bid>();
//        list.add(new Bid());
//        list.add(new Bid());
//        mvc.when(biddingRepo.findAll()).thenReturn(list);
//       List<Bid> res = biddingSer.getAllBid();
//       Mockito.
//    }
}
