package com.example.news_website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class NewsWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsWebsiteApplication.class, args);
	}

}
