package com.bid.BidProject.controller;

import com.bid.BidProject.model.Project;
import com.bid.BidProject.repository.BiddingRepository;
import com.bid.BidProject.repository.ProjectRepository;
import com.bid.BidProject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
     ProjectRepository projectRepo;
    @Autowired
    ProjectService projService;

    @PostMapping(value = "/postproject")
    public Project postProject(@RequestBody Project proj){
        projectRepo.save(proj);
       return  projectRepo.getById(proj.getId());
       // return "success";
    }

    @PostMapping(value = "/postAllProject")
    public String postAllProject(@RequestBody List<Project> projectList){
        projectRepo.saveAll(projectList);
        return "All Saved";

    }
    @GetMapping(value = "/getProject/{id}")
    Project getProject(@PathVariable Integer id){

        Project proj =  projectRepo.getById(id);
        return proj;
    }

    @GetMapping(value = "/getAllProjects")
   List<Project> getProject(){

        return  projectRepo.findAll();

    }


}
