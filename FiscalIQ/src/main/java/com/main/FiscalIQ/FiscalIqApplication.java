package com.main.FiscalIQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FiscalIqApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiscalIqApplication.class, args);
	}

}
