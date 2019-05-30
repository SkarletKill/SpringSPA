package ua.kpi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.entities.Composer;
import ua.kpi.exceptions.ComposerNotFoundException;
import ua.kpi.repositories.ComposerRepository;

import java.util.List;

@Service
public class ComposerService {
    private ComposerRepository repository;

    @Autowired
    public ComposerService(ComposerRepository repository) {
        this.repository = repository;
    }

    public List<Composer> getAllComposers() {
        return repository.findAll();
    }

    public long getComposersCount() { return repository.count(); }

    public Composer newComposer(Composer composer) {
        return repository.save(composer);
    }

    public Composer one(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ComposerNotFoundException(id));
    }

    public Composer replaceComposer(Composer newComposer, Long id) {
        return repository.findById(id)
                .map( composer -> {
                    composer.setName(newComposer.getName());
                    composer.setSurname(newComposer.getSurname());
                    return repository.save(composer);
                }).orElseGet(() -> {
                    newComposer.setId(id);
                    return repository.save(newComposer);
                });
    }

    public void deleteComposer(Long id) {
        repository.deleteById(id);
    }
}
