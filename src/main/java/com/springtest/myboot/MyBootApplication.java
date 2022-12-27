package com.springtest.myboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBootApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hi, this is a web app that saves your favorite songs";
	}
}
