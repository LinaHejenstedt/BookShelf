package se.linahejenstedt.bookshelf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationDB extends SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationAPI.class, args);
	}

}