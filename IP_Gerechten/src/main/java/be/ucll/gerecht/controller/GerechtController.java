package be.ucll.gerecht.controller;

import be.ucll.gerecht.db.DBException;
import be.ucll.gerecht.model.Gerecht;
import be.ucll.gerecht.model.GerechtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class GerechtController {
    @Autowired
    GerechtService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/gerechten")
    public String gerechten(Model model) {
        ArrayList<String> errors = new ArrayList<>();
        if (service.getGerechten().size() > 0) {
            model.addAttribute("gerechten", service.getGerechten());
        } else {
            errors.add("Er staan geen gerechten op het weekmenu.");
            model.addAttribute("errors", errors);
        }
        return "gerechten";
    }

    @GetMapping("/gerechten/change")
    public String gerechtenChange(Model model) {
        ArrayList<String> errors = new ArrayList<>();
        if (service.getGerechten().size() > 0) {
            model.addAttribute("gerechten", service.getGerechten());
        } else {
            errors.add("Er staan geen gerechten op het weekmenu.");
            model.addAttribute("errors", errors);
        }
        return "gerechtenChange";
    }

    @GetMapping("/gerechten/add")
    public String gerechtenChange() {
        return "addGerecht";
    }

    @PostMapping("/gerechten/add")
    public String addGerecht(@Valid Gerecht gerecht, BindingResult bindingResult, Model model) {
        ArrayList<String> errors = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            for (Object object : bindingResult.getAllErrors()) {
                FieldError fieldError = (FieldError) object;
                errors.add(fieldError.getDefaultMessage());
            }
        }
        else{
            try {
                service.addGerecht(gerecht);
            } catch (DBException e) {
                errors.add(e.getMessage());
            }
        }

        if (errors.size() > 0) {
            model.addAttribute("gerecht", gerecht);
            model.addAttribute("errors", errors);
            return "addGerecht";
        }
        return gerechtenChange(model);
    }


    @GetMapping("/gerechten/update/{gerecht.id}")
    public String update(@PathVariable(value = "gerecht.id") int id, Model model) {
        Gerecht gerecht = service.getGerechtById(id);
        model.addAttribute("gerecht", gerecht);
        return "updateGerecht";
    }

    @PostMapping("/gerechten/update")
    public String updateConf(@Valid Gerecht gerecht, BindingResult bindingResult, Model model) {
        ArrayList<String> errors = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            for (Object object : bindingResult.getAllErrors()) {
                FieldError fieldError = (FieldError) object;
                errors.add(fieldError.getDefaultMessage());
            }
        }else{
            try {
                service.updateGerecht(gerecht);
            } catch (DBException e) {
                errors.add(e.getMessage());
            }
        }
        if (errors.size() > 0) {
            model.addAttribute("gerecht", gerecht);
            model.addAttribute("errors", errors);
            return "updateGerecht";
        }
        return gerechtenChange(model);
    }

    @GetMapping("/gerechten/delete/{gerecht.id}")
    public String delete(@PathVariable(value = "gerecht.id") int id, Model model) {
        Gerecht gerecht = service.getGerechtById(id);
        model.addAttribute("gerecht", gerecht);
        return "deleteGerecht";
    }

    @PostMapping("/gerechten/delete/{gerecht.id}")
    public String deleteConf(@PathVariable(value = "gerecht.id") int id, Model model) {
        service.removeGerecht(service.getGerechtById(id));
        return gerechtenChange(model);
    }
}
