package ua.kpi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.models.Statistics;
import ua.kpi.services.StatisticsService;

@RestController
@CrossOrigin(origins = "http://localhost:1337")
public class StatisticsController {

    private StatisticsService service;

    @Autowired
    public StatisticsController(StatisticsService service) {
        this.service = service;
    }

    @GetMapping(
            path = "/statistics",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<Statistics> getStatistics() {
        return ResponseEntity.ok(service.getStatistics());
    }
}
