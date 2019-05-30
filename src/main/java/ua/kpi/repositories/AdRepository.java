package ua.kpi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.entities.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {
}
