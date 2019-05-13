package be.ucll.gerecht.controller;


import be.ucll.gerecht.model.DagMenu;
import be.ucll.gerecht.model.GerechtService;
import be.ucll.gerecht.model.WeekMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    GerechtService service;

    @GetMapping("/weekMenu")
    public List<WeekMenu> weekmenu() {
        return service.getWeekMenus();
    }

    @PostMapping("/dagmenu/add")
    @ResponseStatus(HttpStatus.CREATED)
    public List<WeekMenu> add(@RequestBody @Valid DagMenu dagMenu){
        service.addDagMenu(dagMenu);
        return weekmenu();
    }

    @PostMapping("/dagmenu/change/{dagMenu.datum}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<WeekMenu> update(@PathVariable(value = "dagMenu.datum") String datum,@RequestBody @Valid DagMenu dagMenu){
        service.updateDagMenu(dagMenu);
        return weekmenu();
    }
}
