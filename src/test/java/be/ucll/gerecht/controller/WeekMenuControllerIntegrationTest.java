package be.ucll.gerecht.controller;

import be.ucll.gerecht.Application;
import be.ucll.gerecht.DagMenuBuilder;
import be.ucll.gerecht.GerechtBuilder;
import be.ucll.gerecht.WeekMenuBuilder;
import be.ucll.gerecht.model.DagMenu;
import be.ucll.gerecht.model.Gerecht;
import be.ucll.gerecht.model.WeekMenu;
import be.ucll.gerecht.repository.WeekMenuRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class WeekMenuControllerIntegrationTest {

    WeekMenuBuilder weekMenuBuilder = WeekMenuBuilder.getWeekMenuBuilder();
    DagMenuBuilder dagMenuBuilder = DagMenuBuilder.getDagMenuBuilder();
    GerechtBuilder gerechtBuilder = GerechtBuilder.getGerechtBuilder();
    @Autowired
    private MockMvc menuController;
    @Autowired
    private WeekMenuRepository weekMenuRepository;

    @Test
    public void when_adding_a_dagmenu_all_weekmenus_are_returned() throws Exception {
        Gerecht gerecht1 = gerechtBuilder.withID(1).withDescription("GERECHT1").withPrice(1).withDescription("DAGSCHOTEL").build();
        Gerecht gerecht2 = gerechtBuilder.withID(2).withDescription("GERECHT2").withPrice(2).withDescription("SOEP").build();
        Gerecht gerecht3 = gerechtBuilder.withID(3).withDescription("GERECHT3").withPrice(3).withDescription("VEGGIE").build();

        DagMenu aDagMenu = dagMenuBuilder.withDag("Vrijdag").withDatum("24/05/2019").withVeggie(gerecht3).withSoep(gerecht2).withDagschotel(gerecht1).build();
        WeekMenu aWeekMenu = weekMenuBuilder.withID(3).withDagMenu(aDagMenu).build();
        weekMenuRepository.saveAndFlush(aWeekMenu);

        menuController.perform(get("/weekMenu")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].dagMenus[0].datum").value("24/05/2019"));
    }
}


