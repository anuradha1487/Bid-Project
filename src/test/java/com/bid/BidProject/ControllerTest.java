package com.bid.BidProject;

import com.bid.BidProject.controller.BiddingController;
import com.bid.BidProject.model.Bid;
import com.bid.BidProject.model.Project;
import com.bid.BidProject.service.BiddingService;
import com.bid.BidProject.service.ProjectService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.regex.Matcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerTest {

    private MockMvc mvc;

    @MockBean
    BiddingController cont;

    @MockBean
    BiddingService ser;

    @MockBean
    ProjectService projService;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(cont).build();
    }

    @Test
    public void getBid() throws Exception{
        mvc.perform(get("/bid/getBidAll"))
                        .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void getBidTest() throws  Exception{

        Bid bid = new Bid();
        bid.setBidType("total");
        Mockito.when(cont.getBid(1)).thenReturn(bid);
        mvc.perform(get("/bid/getBid/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.bidType", Matchers.is("total")));
    }

    @Test
    public void isDeadlineOverDueTest(){
        Project proj = new Project();
        proj.setDatetime(new Date());
        Mockito.when(projService.getProject(1)).thenReturn(proj);

        Assert.assertEquals(false,ser.isDeadlineOverDue(1));

    }
}
