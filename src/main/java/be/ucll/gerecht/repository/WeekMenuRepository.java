package be.ucll.gerecht.repository;

import be.ucll.gerecht.model.WeekMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekMenuRepository extends JpaRepository<WeekMenu,Long> {
    WeekMenu findWeekMenuById(int id);
}
