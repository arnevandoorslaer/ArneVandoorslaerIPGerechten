package be.ucll.gerecht.model;

public class WeekMenu {
    DagMenu[] menus = new DagMenu[3];

    public void addDagMenu(DagMenu dagMenu){
        for (int i = 0; i < menus.length; i++) {
            if(menus[i] == null) menus[i] = dagMenu;
        }
    }

    public DagMenu[] getAll(){
        return this.menus;
    }
}
