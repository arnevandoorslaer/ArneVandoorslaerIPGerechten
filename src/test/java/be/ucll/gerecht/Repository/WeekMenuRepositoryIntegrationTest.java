package be.ucll.gerecht.Repository;

import be.ucll.gerecht.WeekMenuBuilder;
import be.ucll.gerecht.model.WeekMenu;
import be.ucll.gerecht.repository.WeekMenuRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@AutoConfigureMockMvc(secure = false)
@RunWith(SpringRunner.class)
@DataJpaTest
public class WeekMenuRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private WeekMenuRepository weekMenuRepository;

    WeekMenuBuilder weekMenuBuilder = WeekMenuBuilder.getWeekMenuBuilder();
    WeekMenu anOkWeekMenu,anotherWeekMenu;

    @Test
    public void should_find_all_WeekMenus(){
        anOkWeekMenu = weekMenuBuilder.withID(1).withAnOkDagMenu().build();
        entityManager.persist(anOkWeekMenu);
        entityManager.flush();

        anotherWeekMenu = weekMenuBuilder.withID(2).build();
        entityManager.persist(anotherWeekMenu);
        entityManager.flush();

        List<WeekMenu> menus = weekMenuRepository.findAll();

        assertThat(menus.size()).isEqualTo(2);
        assertThat(menus).contains(anOkWeekMenu);
        assertThat(menus).contains(anotherWeekMenu);
        entityManager.flush();
    }

    @Test
    public void should_find_weekmenu_by_weeknumber(){
        anOkWeekMenu = weekMenuBuilder.withID(3).withAnOkDagMenu().build();

        entityManager.persist(anOkWeekMenu);
        entityManager.flush();
        WeekMenu foundMenu = weekMenuRepository.findWeekMenuById(anOkWeekMenu.getId());
        assertThat(foundMenu).isEqualTo(anOkWeekMenu);
        assertThat(foundMenu.getDagMenus()).contains(anOkWeekMenu.getDagMenus().get(0));


    }
}
