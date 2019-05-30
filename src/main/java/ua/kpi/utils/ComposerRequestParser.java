package ua.kpi.utils;

import lombok.Data;
import org.springframework.stereotype.Service;
import ua.kpi.entities.Composer;
import ua.kpi.models.ComposerDetailsRequestModel;

import java.util.Collections;

@Service
public class ComposerRequestParser {
    public Composer getComposer(ComposerDetailsRequestModel model) {
        Composer composer = new Composer();
        composer.setName(model.getName());
        composer.setSurname(model.getSurname());
        composer.setCompositions(Collections.emptySet());
        return composer;
    }
}
