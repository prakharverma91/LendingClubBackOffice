package com.club;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LendingClubBackOfficeApplication {

	public static Logger logger = LoggerFactory.getLogger(LendingClubBackOfficeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LendingClubBackOfficeApplication.class, args);
	}



}

