package be.ucll.gerecht;

import be.ucll.gerecht.model.DagMenu;
import be.ucll.gerecht.model.WeekMenu;

import java.util.ArrayList;

public class WeekMenuBuilder {
    private int id;
    private ArrayList<DagMenu> menus;
    private DagMenuBuilder dagMenuBuilder;

    private WeekMenuBuilder() {
        menus = new ArrayList<>();
        dagMenuBuilder = DagMenuBuilder.getDagMenuBuilder();
    }

    public static WeekMenuBuilder getWeekMenuBuilder() {
        return new WeekMenuBuilder();
    }

    public WeekMenuBuilder withID(int id) {
        this.id = id;
        return this;
    }

    public WeekMenuBuilder withDagMenu(DagMenu dagMenu) {
        this.menus.add(dagMenu);
        return this;
    }

    public WeekMenuBuilder withAnOkDagMenu() {
        this.menus.add(dagMenuBuilder.withDag("Maandag").withDatum("20/05/2019").withAnOkVeggie().withAnOkDagschotel().withAnOkSoep().build());
        return this;
    }

    public WeekMenu build() {
        return new WeekMenu(id, menus);
    }
}
