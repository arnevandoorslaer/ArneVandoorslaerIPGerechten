package be.ucll.gerecht;

import be.ucll.gerecht.model.DagMenu;
import be.ucll.gerecht.model.Gerecht;
import be.ucll.gerecht.repository.GerechtRepository;
import be.ucll.gerecht.repository.WeekMenuRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner runner(GerechtRepository gerechtRepository){
        return args -> {
            gerechtRepository.save(new Gerecht("Spaghetti", 3.4, "VEGGIE"));
            gerechtRepository.save(new Gerecht("Vol au vent", 3, "DAGSCHOTEL"));
            gerechtRepository.save(new Gerecht("Tomatensoep", .50, "SOEP"));
            gerechtRepository.save(new Gerecht("Groentensoep", 1, "SOEP"));
            gerechtRepository.save(new Gerecht("Pompoensoep", 0.75, "SOEP"));
            gerechtRepository.save(new Gerecht("Aspergesoep", 0.50, "SOEP"));
            gerechtRepository.save(new Gerecht("Balletjes in tomatensaus", 3.50, "DAGSCHOTEL"));
            gerechtRepository.save(new Gerecht("Pasta scampi", 3.10, "DAGSCHOTEL"));
            gerechtRepository.save(new Gerecht("Pasta kip", 3.25, "DAGSCHOTEL"));
        };
    }

}
