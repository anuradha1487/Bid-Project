package com.bid.BidProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BidProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BidProjectApplication.class, args);
	}

}
