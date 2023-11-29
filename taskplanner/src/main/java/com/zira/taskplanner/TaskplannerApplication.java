package com.zira.taskplanner;

import com.zira.taskplanner.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TaskplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskplannerApplication.class, args);
	}

}
