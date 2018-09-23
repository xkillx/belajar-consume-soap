package com.example.demo;

import com.example.demo.soap.CelsiusToFahrenheit;
import com.example.demo.soap.CelsiusToFahrenheitResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(TestClient client) {
		return args -> {

			logger.info("------->" + client.call().getCelsiusToFahrenheitResult());
		};
	}
}
