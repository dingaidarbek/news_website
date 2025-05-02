package com.example.news_website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    public MainService mainService;

    @Value("${mediastack.api.key}")
    private String apiKey;

    @GetMapping("/news")
    public ResponseEntity<String> getNews() {
        String json = mainService.getNews(apiKey);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(json);
    }

    @GetMapping("/news/categories")
    public ResponseEntity<String> getNewsByCategory(@RequestParam String categories) {
        String json = mainService.getNewsByCategories(apiKey, categories);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(json);
    }
}
