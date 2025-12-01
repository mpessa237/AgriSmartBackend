package com.herve.AgriSmartBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AgriSmartBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgriSmartBackEndApplication.class, args);
	}

}
