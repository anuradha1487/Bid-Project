package com.bid.BidProject.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String projectDesc;
    public int totalHours;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date datetime;
    public int customerId;


//    public List<Bid> getBidList() {
//        return bidList;
//    }
//
//    public void setBidList(List<Bid> bidList) {
//        this.bidList = bidList;
//    }
//
//    @OneToMany(targetEntity = Bid.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "pb_fk", referencedColumnName = "id")
//    List<Bid> bidList ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
