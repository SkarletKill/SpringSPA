package ua.kpi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kpi.entities.Ad;
import ua.kpi.models.AdDetailsRequestModel;
import ua.kpi.services.AdService;
import ua.kpi.utils.AdRequestParser;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:1337")
public class AdController {
    private AdService service;
    private AdRequestParser parser;

    @Autowired
    public AdController(AdService service, AdRequestParser parser) {
        this.service = service;
        this.parser = parser;
    }

    @GetMapping(
            path = "/ads",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<List<Ad>> index() { return ResponseEntity.ok(service.getAllAds()); }

    @GetMapping(
            path = "/ads/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<Ad> one(@PathVariable Long id) {
        return ResponseEntity.ok(service.one(id));
    }

    @PostMapping(
            path = "/ads",
            consumes = {MediaType.APPLICATION_JSON_VALUE },
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<Ad> newAd(@RequestBody AdDetailsRequestModel model) {
        Ad newAd = parser.getAd(model);
        return ResponseEntity.ok(service.newAd(newAd));
    }

    @PutMapping(
            path = "/ads/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE },
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<Ad> replaceAd(@RequestBody AdDetailsRequestModel model, @PathVariable Long id) {
        Ad newAd = parser.getAd(model);
        return ResponseEntity.ok(service.replaceAd(newAd, id));
    }

    @DeleteMapping(
            path = "/ads/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    ResponseEntity deleteAd(@PathVariable Long id) {
        service.deleteAd(id);
        return ResponseEntity.ok(null);
    }
}
