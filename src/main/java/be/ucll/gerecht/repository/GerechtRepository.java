package be.ucll.gerecht.repository;

import be.ucll.gerecht.model.Gerecht;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerechtRepository extends JpaRepository<Gerecht, Integer> {
    Gerecht findByDescription(String description);

    Gerecht findById(int id);
}
