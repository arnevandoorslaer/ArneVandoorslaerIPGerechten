package be.ucll.gerecht.controller;

import be.ucll.gerecht.DagMenuBuilder;
import be.ucll.gerecht.WeekMenuBuilder;
import be.ucll.gerecht.model.DagMenu;
import be.ucll.gerecht.model.GerechtService;
import be.ucll.gerecht.model.WeekMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(secure = false)
@RunWith(SpringRunner.class)
@WebMvcTest(MenuController.class)
public class WeekMenuControllerUnitTest {

    WeekMenuBuilder weekMenuBuilder = WeekMenuBuilder.getWeekMenuBuilder();
    DagMenuBuilder dagMenuBuilder = DagMenuBuilder.getDagMenuBuilder();
    @Autowired
    private MockMvc menuController;
    @MockBean
    private GerechtService gerechtService;

    @Test
    public void when_adding_a_dagmenu_all_weekmenus_are_returned() throws Exception {

        DagMenu aDagMenu = dagMenuBuilder.withDag("Maandag").withDatum("20/07/2019").withAnOkDagschotel().withAnOkSoep().withAnOkVeggie().build();
        DagMenu anotherDagMenu = dagMenuBuilder.withDag("Dinsdag").withDatum("21/07/2019").withAnOkDagschotel().withAnOkSoep().withAnOkVeggie().build();
        WeekMenu aWeekMenu = weekMenuBuilder.withID(1).withDagMenu(aDagMenu).withDagMenu(anotherDagMenu).build();

        Mockito.when(gerechtService.getWeekMenus()).thenReturn(Arrays.asList(aWeekMenu));

        menuController.perform(get("/weekMenu")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].dagMenus[0].datum").value(aDagMenu.getDatum()))
                .andExpect(jsonPath("$[0].dagMenus[1].datum").value(anotherDagMenu.getDatum()));


    }
}

