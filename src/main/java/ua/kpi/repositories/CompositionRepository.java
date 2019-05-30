package ua.kpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.entities.Composer;
import ua.kpi.entities.Composition;

import java.util.List;
import java.util.Optional;

public interface CompositionRepository extends JpaRepository<Composition, Long> {
    List<Composition> findAll();
    List<Composition> findAllByComposer(Composer composer);
    Optional<Composition> findById(Long id);
}
