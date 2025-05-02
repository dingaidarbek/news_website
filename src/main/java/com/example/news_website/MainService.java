package com.example.news_website;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MainService {
    private final RestTemplate restTemplate;

    public MainService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getNews(String apiKey) {
        String url = "http://api.mediastack.com/v1/news?access_key="+apiKey+"&languages=en";
        return restTemplate.getForObject(url, String.class);
    }
}
