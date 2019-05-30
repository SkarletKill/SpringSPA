package ua.kpi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kpi.entities.Composition;
import ua.kpi.models.CompositionDetailsRequestModel;
import ua.kpi.services.CompositionService;
import ua.kpi.utils.CompositionRequestParser;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:1337")
public class CompositionController {
    private CompositionService compositionService;
    private CompositionRequestParser parser;

    @Autowired
    public CompositionController(CompositionService compositionService, CompositionRequestParser parser) {
        this.compositionService = compositionService;
        this.parser = parser;
    }

    @GetMapping(
            path = "/compositions",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<List<Composition>> index() {
        List<Composition> compositions = compositionService.getAllCompositions();
        return ResponseEntity.ok(compositions);
    }

    @GetMapping(
            path = "/compositions/composer/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<List<Composition>> indexByComposer(@PathVariable Long id) {
        List<Composition> compositions = compositionService.getByComposerId(id);
        return ResponseEntity.ok(compositions);
    }

    @GetMapping(
            path = "/composition/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    ResponseEntity<Composition> one(@PathVariable Long id) {
        return ResponseEntity.ok(compositionService.one(id));
    }

    @PostMapping(
            path = "/compositions",
            consumes = {MediaType.APPLICATION_JSON_VALUE },
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<Composition> newComposition(@RequestBody CompositionDetailsRequestModel newCompositionModel) {
        Composition newComposition = parser.getComposition(newCompositionModel);


        Composition composition = compositionService.newComposition(newComposition);
        return ResponseEntity.ok(composition);
    }

    @PutMapping(
            path = "/composition/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE },
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    ResponseEntity<Composition> replaceComposition(@RequestBody CompositionDetailsRequestModel newCompositionModel, @PathVariable Long id) {
        Composition newComposition = parser.getComposition(newCompositionModel);

        Composition composition = compositionService.replaceComposition(newComposition, id);
        return ResponseEntity.ok(composition);
    }

    @DeleteMapping(
            path = "/composition/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    ResponseEntity deleteComposition(@PathVariable Long id) {
        compositionService.deleteComposition(id);
        return ResponseEntity.ok(null);
    }
}
