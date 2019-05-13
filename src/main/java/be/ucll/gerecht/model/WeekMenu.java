package be.ucll.gerecht.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WeekMenu {
    @OneToMany
    List<DagMenu> menus;
    @JsonIgnore
    @Id
    private int id;

    public WeekMenu(int id) {
        setId(id);
        menus = new ArrayList<>();

    }

    public WeekMenu(){};

    public void updateDagMenu(DagMenu dg){
        menus.remove(dg);
        menus.add(dg);
    }

    public void addDagMenu(DagMenu dagMenu) {
        menus.add(dagMenu);
    }

    public void removeDagMenu(DagMenu dagMenu) {
        menus.remove(dagMenu);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<DagMenu> getDagMenus() {
        return this.menus;
    }
}
