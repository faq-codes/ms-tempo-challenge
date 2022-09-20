package com.faq.suba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableRetry
@EnableWebMvc
@EnableCaching
@EnableScheduling
@SpringBootApplication
public class SubaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubaApplication.class, args);
	}

}
