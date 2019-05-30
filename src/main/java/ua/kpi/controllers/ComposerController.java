package ua.kpi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kpi.entities.Composer;
import ua.kpi.models.ComposerDetailsRequestModel;
import ua.kpi.services.ComposerService;
import ua.kpi.utils.ComposerRequestParser;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:1337")
public class ComposerController {
    private ComposerService service;
    private ComposerRequestParser parser;

    @Autowired
    public ComposerController(ComposerService service, ComposerRequestParser parser) {
        this.service = service;
        this.parser = parser;
    }

    @GetMapping(
            path = "/composers",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<List<Composer>> index() {
        return ResponseEntity.ok(service.getAllComposers());
    }

    @GetMapping(
            path = "/composer/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<Composer> one(@PathVariable Long id) {
        return ResponseEntity.ok(service.one(id));
    }

    @PostMapping(
            path = "/composer",
            consumes = {MediaType.APPLICATION_JSON_VALUE },
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<Composer> newComposer(@RequestBody ComposerDetailsRequestModel model) {
        Composer newComposer = parser.getComposer(model);
        return ResponseEntity.ok(service.newComposer(newComposer));
    }

    @PutMapping(
            path = "/composer/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE },
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<Composer> replaceComposer(@RequestBody ComposerDetailsRequestModel model, @PathVariable Long id) {
        Composer newComposer = parser.getComposer(model);
        return ResponseEntity.ok(service.replaceComposer(newComposer, id));
    }

    @DeleteMapping(
            path = "/composer/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    ResponseEntity deleteComposer(@PathVariable Long id) {
        service.deleteComposer(id);
        return ResponseEntity.ok(null);
    }
}
