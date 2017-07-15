package com.test.core.log;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App implements CommandLineRunner {
	
	@Resource(name = "testService")
	private TestService testService;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(App.class);
		application.run(args);
	}

	public void run(String... args) throws Exception {
		testService.test("yinlong",99);
	}
}

