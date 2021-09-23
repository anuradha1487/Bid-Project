package com.bid.BidProject.service;

import com.bid.BidProject.model.Project;
import com.bid.BidProject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projRepo;
    public Project getProject(int id){
       return projRepo.getById(id);
    }


}
