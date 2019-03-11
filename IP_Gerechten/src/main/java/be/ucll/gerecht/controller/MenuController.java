package be.ucll.gerecht.controller;


import be.ucll.gerecht.model.GerechtService;
import be.ucll.gerecht.model.WeekMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    GerechtService service;

    @GetMapping("/weekMenu")
    public List<WeekMenu> weekmenu() {
        return service.getWeekMenus();
    }
}
