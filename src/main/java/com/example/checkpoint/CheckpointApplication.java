package com.example.checkpoint;

import com.example.checkpoint.service.CheckPointApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckpointApplication {
	public static void main(String[] args) {
		var run = SpringApplication.run(CheckpointApplication.class, args);
		run.getBean(CheckPointApplicationContext.class).executeContext();
	}

}
