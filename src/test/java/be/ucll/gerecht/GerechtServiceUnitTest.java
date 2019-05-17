package be.ucll.gerecht;

import be.ucll.gerecht.model.Gerecht;
import be.ucll.gerecht.model.GerechtService;
import be.ucll.gerecht.model.WeekMenu;
import be.ucll.gerecht.repository.GerechtRepository;
import be.ucll.gerecht.repository.WeekMenuRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class GerechtServiceUnitTest {
    @TestConfiguration
    static class GerechtServiceTestContextConfiguration {

        // Creates an instance of service in order to be able to autowire it
        @Bean
        public GerechtService gerechtService() {
            return new GerechtService();
        }
    }
    @Autowired
    private GerechtService gerechtService;


    // Service is dependent of Repository, however implementation of Repository is
    // not important => therefor mock it
    // Mock support of Spring Boot Test
    @MockBean
    private GerechtRepository gerechtRepository;
    @MockBean
    private WeekMenuRepository weekMenuRepository;

    private Gerecht one, two, three;
    private List<Gerecht> gerechten;
    private List<WeekMenu> weekMenus;

    @Before
    public void setUp() {
        one = new Gerecht("Spaghetti", 3.4, "VEGGIE");
        two = new Gerecht("Tomatensoep", .50, "SOEP");
        three = new Gerecht("Aspergesoep", 0.50, "SOEP");
        gerechten = new ArrayList<>();
        weekMenus = new ArrayList<>();
        gerechten.add(one);
        gerechten.add(two);
        gerechten.add(three);
    }

    @Test
    public void should_get_all_gerechten () {
        // Mock
        Mockito.when(gerechtRepository.findAll()).thenReturn(gerechten);

        //when
        List<Gerecht> foundGerechten = gerechtService.getGerechten();

        //then
        assertThat(foundGerechten.size()).isEqualTo(3);
        assertThat(foundGerechten).contains(one);
        assertThat(foundGerechten).contains(two);
        assertThat(foundGerechten).contains(three);
    }

    @Test
    public void should_find_gerecht_by_given_description () {
        // Mock
        // When we ask at the repo for the ok feedback, it will return it
        Mockito.when(gerechtRepository.findByDescription(one.getDescription())).thenReturn(one);

        // given
        String description = "Spaghetti";
        double price = 3.4;
        String type = "VEGGIE";

        // when
        Gerecht found = gerechtService.getGerecht(description);

        // then
        assertThat(found.getDescription()).isEqualTo(description);
        assertThat(found.getPrice()).isEqualTo(price);
        assertThat(found.getType()).isEqualTo(type);
    }

    @Test
    public void gerecht_is_added_when_al_values_are_correct () {
        //Mock
        Mockito.when(gerechtRepository.save(three)).thenReturn(three);

        //when
        Gerecht addedGerecht = gerechtService.addGerecht(three);

        //then
        assertThat(addedGerecht.getDescription()).isEqualTo("Aspergesoep");
        assertThat(addedGerecht.getType()).isEqualTo("SOEP");
        assertThat(addedGerecht.getPrice()).isEqualTo(0.50);
    }

}
