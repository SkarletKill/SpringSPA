package ua.kpi.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.entities.Composer;
import ua.kpi.entities.Composition;
import ua.kpi.models.CompositionDetailsRequestModel;
import ua.kpi.repositories.ComposerRepository;

@Getter
@Setter
@Service
public class CompositionRequestParser {
    private ComposerRepository composerRepository;

    public CompositionRequestParser() {
    }

    @Autowired
    public CompositionRequestParser(ComposerRepository composerRepository) {
        this.composerRepository = composerRepository;
    }

    public Composition getComposition(CompositionDetailsRequestModel model) {
        if (model == null) { return null; }

        Composer composer = composerRepository.findById(model.getComposerId()).orElse(null);
        Composition composition = new Composition();
        composition.setComposer(composer);
        composition.setDuration(model.getDuration());
        composition.setName(model.getName());
        return composition;
    }
}
