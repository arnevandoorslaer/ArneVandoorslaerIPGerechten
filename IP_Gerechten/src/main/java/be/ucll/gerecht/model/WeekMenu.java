package be.ucll.gerecht.model;

import java.util.ArrayList;

public class WeekMenu {
    ArrayList<DagMenu> menus;
    private int id;

    public WeekMenu(int id) {
        setId(id);
        menus = new ArrayList<>();
    }

    public void addDagMenu(DagMenu dagMenu) {
        menus.add(dagMenu);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<DagMenu> getDagMenus() {
        return this.menus;
    }
}
