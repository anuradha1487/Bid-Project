package com.bid.BidProject.repository;

import com.bid.BidProject.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository  extends JpaRepository<Project, Integer> {

}
