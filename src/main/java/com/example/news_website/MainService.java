package com.example.news_website;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MainService {
    private final RestTemplate restTemplate;

    public MainService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("news")
    public String getNews(String apiKey) {
        String url = "http://api.mediastack.com/v1/news?access_key="+apiKey+"&languages=en";
        return restTemplate.getForObject(url, String.class);
    }

    @Cacheable("categories")
    public String getNewsByCategories(String apiKey, String categories) {
        String url = "http://api.mediastack.com/v1/news?access_key="+apiKey+"&languages=en&categories="+categories;
        return restTemplate.getForObject(url, String.class);
    }

    @Cacheable("digest")
    public String getDigest(String apiKey) {
        String url = "https://newsapi.org/v2/top-headlines?apiKey=" + apiKey + "&language=en&pageSize=7";
        return restTemplate.getForObject(url, String.class);
    }

}
