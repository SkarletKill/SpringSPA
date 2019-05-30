package ua.kpi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.entities.Composer;
import ua.kpi.entities.Composition;
import ua.kpi.exceptions.CompositionNotFoundException;
import ua.kpi.repositories.CompositionRepository;

import java.util.List;

@Service
public class CompositionService {
    private CompositionRepository compositionRepository;
    private ComposerService composerService;

    @Autowired
    public CompositionService(CompositionRepository compositionRepository, ComposerService composerService) {
        this.compositionRepository = compositionRepository;
        this.composerService = composerService;
    }

    public List<Composition> getAllCompositions() {
        return compositionRepository.findAll();
    }

    public long getCompositionCount() { return compositionRepository.count(); }

    public Composition newComposition(Composition composition) {
        return compositionRepository.save(composition);
    }

    public Composition one(Long id) {
        return compositionRepository.findById(id)
                .orElseThrow(() -> new CompositionNotFoundException(id));
    }

    public List<Composition> getByComposerId(Long id) {
        Composer composer = composerService.one(id);
        return compositionRepository.findAllByComposer(composer);
    }

    public Composition replaceComposition(Composition newComposition, Long id) {
        return compositionRepository.findById(id)
                .map(composition -> {
                    composition.setName(newComposition.getName());
                    composition.setDuration(newComposition.getDuration());
                    composition.setComposer(newComposition.getComposer());
                    return compositionRepository.save(composition);
                })
                .orElseGet(() -> {
                    newComposition.setId(id);
                    return compositionRepository.save(newComposition);
                });
    }

    public void deleteComposition(Long id) {
        compositionRepository.deleteById(id);
    }
}
