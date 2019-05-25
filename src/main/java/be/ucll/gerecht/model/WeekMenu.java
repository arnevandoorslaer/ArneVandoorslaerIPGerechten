package be.ucll.gerecht.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WeekMenu implements Serializable {
    @OneToMany(cascade = CascadeType.ALL)
    List<DagMenu> menus;
    @JsonIgnore
    @Id
    private int id;

    public WeekMenu(int id) {
        setId(id);
        menus = new ArrayList<>();
    }

    public WeekMenu(int id,ArrayList<DagMenu> menus) {
        setId(id);
        this.menus = menus;
    }

    public WeekMenu() {
    }

    public void updateDagMenu(DagMenu dg) {
        menus.remove(dg);
        menus.add(dg);
    }

    public void addDagMenu(DagMenu dagMenu) {
        for (DagMenu menu : menus) {
            if (menu.equals(dagMenu)) {
                throw new DomainException("Dagmenu already exists");
            }
        }
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
