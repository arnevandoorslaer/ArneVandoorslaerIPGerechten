package be.ucll.gerecht.model;

import be.ucll.gerecht.DagMenuBuilder;
import be.ucll.gerecht.GerechtBuilder;
import be.ucll.gerecht.WeekMenuBuilder;
import be.ucll.gerecht.repository.GerechtRepository;
import be.ucll.gerecht.repository.WeekMenuRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureMockMvc(secure = false)
@RunWith(SpringRunner.class)
public class GerechtServiceUnitTest {
    @Autowired
    private GerechtService gerechtService;
    // Service is dependent of Repository, however implementation of Repository is
    // not important => therefor mock it
    // Mock support of Spring Boot Test
    @MockBean
    private GerechtRepository gerechtRepository;
    @MockBean
    private WeekMenuRepository weekMenuRepository;
    private Gerecht gone, gtwo, gthree, gfour, gfive, gsix, gseven, geight, gnine;
    private DagMenu done, dtwo, dthree;
    private WeekMenu wone, wtwo;
    private List<Gerecht> gerechten;
    private List<WeekMenu> weekMenus;
    private WeekMenuBuilder weekMenuBuilder = WeekMenuBuilder.getWeekMenuBuilder();
    private DagMenuBuilder dagMenuBuilder = DagMenuBuilder.getDagMenuBuilder();
    private GerechtBuilder gerechtBuilder = GerechtBuilder.getGerechtBuilder();

    @Before
    public void setUp() {
        gone = gerechtBuilder.withID(1).withDescription("Spaghetti").withPrice(3.4).withType("VEGGIE").build();
        gtwo = gerechtBuilder.withID(2).withDescription("Tomatensoep").withPrice(.50).withType("SOEP").build();
        gthree = gerechtBuilder.withID(3).withDescription("Aspergesoep").withPrice(0.50).withType("SOEP").build();
        gfour = gerechtBuilder.withID(1).withDescription("Hamburger").withPrice(3.4).withType("DAGSCHOTEL").build();
        gfive = gerechtBuilder.withID(2).withDescription("Pizza").withPrice(9).withType("DAGSCHOTEL").build();
        gsix = gerechtBuilder.withID(3).withDescription("Bloemkoolsoep").withPrice(0.50).withType("SOEP").build();
        gseven = gerechtBuilder.withID(1).withDescription("Smos").withPrice(2.65).withType("DAGSCHOTEL").build();
        geight = gerechtBuilder.withID(2).withDescription("Smikkel").withPrice(3).withType("VEGGIE").build();
        gnine = gerechtBuilder.withID(3).withDescription("Smakkel").withPrice(0.50).withType("VEGGIE").build();

        done = dagMenuBuilder.withDag("Maandag").withDatum("20/05/2019").withDagschotel(gfour).withSoep(gtwo).withVeggie(gone).build();
        dtwo = dagMenuBuilder.withDag("Dinsdag").withDatum("21/05/2019").withDagschotel(gfive).withSoep(gthree).withVeggie(geight).build();
        dthree = dagMenuBuilder.withDag("Maandag").withDatum("27/05/2019").withDagschotel(gseven).withSoep(gsix).withVeggie(gnine).build();

        wone = weekMenuBuilder.withID(1).withDagMenu(done).withDagMenu(dtwo).build();
        wtwo = weekMenuBuilder.withID(2).withDagMenu(dthree).build();

        gerechten = new ArrayList<>();
        weekMenus = new ArrayList<>();

        gerechten.add(gone);
        gerechten.add(gtwo);
        gerechten.add(gthree);

        weekMenus.add(wone);
        weekMenus.add(wtwo);
    }

    @Test
    public void should_get_all_gerechten() {
        Mockito.when(gerechtRepository.findAll()).thenReturn(gerechten);

        List<Gerecht> foundGerechten = gerechtService.getGerechten();

        assertThat(foundGerechten.size()).isEqualTo(3);
        assertThat(foundGerechten).contains(gone);
        assertThat(foundGerechten).contains(gtwo);
        assertThat(foundGerechten).contains(gthree);
    }

    @Test
    public void should_find_gerecht_by_given_description() {
        Mockito.when(gerechtRepository.findByDescription(gone.getDescription())).thenReturn(gone);

        String description = "Spaghetti";
        double price = 3.4;
        String type = "VEGGIE";

        Gerecht found = gerechtService.getGerecht(description);

        assertThat(found.getDescription()).isEqualTo(description);
        assertThat(found.getPrice()).isEqualTo(price);
        assertThat(found.getType()).isEqualTo(type);
    }

    @Test
    public void gerecht_is_added_when_al_values_are_correct() {
        Mockito.when(gerechtRepository.save(gthree)).thenReturn(gthree);

        Gerecht addedGerecht = gerechtService.addGerecht(gthree);

        assertThat(addedGerecht.getDescription()).isEqualTo("Aspergesoep");
        assertThat(addedGerecht.getType()).isEqualTo("SOEP");
        assertThat(addedGerecht.getPrice()).isEqualTo(0.50);
    }

    @Test
    public void gerecht_is_correctly_removed() {
        Mockito.when(gerechtRepository.findByDescription(gthree.getDescription())).thenReturn(gthree);

        gerechtService.removeGerecht(gthree);

        assertThat(gerechtService.getGerechten()).doesNotContain(gthree);
    }

    @Test
    public void should_update_gerecht() {
        Mockito.when(gerechtRepository.save(gtwo))
                .thenReturn(gtwo);
        Mockito.when(gerechtRepository.findById(gtwo.getId()))
                .thenReturn(gtwo);

        String newDescription = "test";

        gtwo.setDescription(newDescription);
        gtwo.setPrice(9);
        gerechtService.updateGerecht(gtwo);

        assertThat(gerechtRepository.findById(gtwo.getId()).getDescription()).isEqualTo(newDescription);
        assertThat(gerechtRepository.findById(gtwo.getId()).getPrice()).isEqualTo(9);
    }

    @Test
    public void should_find_all_WeekMenus() {
        Mockito.when(weekMenuRepository.findAll()).thenReturn(weekMenus);

        List<WeekMenu> foundMenus = gerechtService.getWeekMenus();

        assertThat(foundMenus.size()).isEqualTo(2);
        assertThat(foundMenus).contains(wone);
        assertThat(foundMenus).contains(wtwo);
    }

    @TestConfiguration
    static class GerechtServiceTestContextConfiguration {

        // Creates an instance of service in order to be able to autowire it
        @Bean
        public GerechtService gerechtService() {
            return new GerechtService();
        }
    }

}
