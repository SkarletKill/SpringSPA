package ua.kpi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kpi.entities.News;
import ua.kpi.models.NewsDetailsRequestModel;
import ua.kpi.services.NewsService;
import ua.kpi.utils.NewsRequestParser;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:1337")
public class NewsController {
    private NewsService service;
    private NewsRequestParser parser;

    @Autowired
    public NewsController(NewsService service, NewsRequestParser parser) {
        this.service = service;
        this.parser = parser;
    }

    @GetMapping(
            path = "/news",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<List<News>> index() { return ResponseEntity.ok(service.getAllNews()); }

    @GetMapping(
            path = "/news/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<News> one(@PathVariable Long id) {
        return ResponseEntity.ok(service.one(id));
    }

    @PostMapping(
            path = "/news",
            consumes = {MediaType.APPLICATION_JSON_VALUE },
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<News> newNews(@RequestBody NewsDetailsRequestModel model) {
        News newNews = parser.getNews(model);
        return ResponseEntity.ok(service.newNews(newNews));
    }

    @PutMapping(
            path = "/news/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE },
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<News> replaceNews(@RequestBody NewsDetailsRequestModel model, @PathVariable Long id) {
        News newNews = parser.getNews(model);
        return ResponseEntity.ok(service.replaceNews(newNews, id));
    }

    @DeleteMapping(
            path = "/news/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    ResponseEntity deleteNews(@PathVariable Long id) {
        service.deleteNews(id);
        return ResponseEntity.ok(null);
    }
}
