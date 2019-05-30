package ua.kpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.entities.Composer;

import java.util.Optional;

public interface ComposerRepository extends JpaRepository<Composer, Long> {
    Optional<Composer> findById(Long id);
}
