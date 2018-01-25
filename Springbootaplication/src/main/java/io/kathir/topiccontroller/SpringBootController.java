package io.kathir.topiccontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ActiveProfiles("test")
public class SpringBootController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SpringApplication.run(SpringBootController.class, args);
	}

}
