package ua.kpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.entities.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}
