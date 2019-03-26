package be.ucll.gerecht.db;

import be.ucll.gerecht.model.DagMenu;
import be.ucll.gerecht.model.Gerecht;
import be.ucll.gerecht.model.WeekMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GerechtDB {
    private List<Gerecht> gerechten;
    private List<WeekMenu> weekMenus;
    private int CURRENT_ID = 1000;
    private AtomicInteger weekId = new AtomicInteger();
    private AtomicInteger dagId = new AtomicInteger();

    public GerechtDB() {
        this.gerechten = new ArrayList<>();
        this.weekMenus = new ArrayList<>();
        init();
    }

    private void init() {
        addGerecht(new Gerecht("Spaghetti", 3.4, "VEGGIE"));
        addGerecht(new Gerecht("Vol au vent", 3, "DAGSCHOTEL"));
        addGerecht(new Gerecht("Tomatensoep", .50, "SOEP"));
        addGerecht(new Gerecht("Groentensoep", 1, "SOEP"));
        addGerecht(new Gerecht("Pompoensoep", 0.75, "SOEP"));
        addGerecht(new Gerecht("Aspergesoep", 0.50, "SOEP"));
        addGerecht(new Gerecht("Balletjes in tomatensaus", 3.50, "DAGSCHOTEL"));
        addGerecht(new Gerecht("Pasta scampi", 3.10, "DAGSCHOTEL"));
        addGerecht(new Gerecht("Pasta kip", 3.25, "DAGSCHOTEL"));

        WeekMenu weekMenu1 = new WeekMenu(weekId.incrementAndGet());
        weekMenu1.addDagMenu(new DagMenu(dagId.incrementAndGet(), "Dinsdag", "19/02/2019", getGerecht("Spaghetti"), getGerecht("Aspergesoep"), getGerecht("Vol au vent")));
        weekMenu1.addDagMenu(new DagMenu(dagId.incrementAndGet(), "Woensdag", "20/02/2019", getGerecht("Spaghetti"), getGerecht("Groentensoep"), getGerecht("Pasta scampi")));
        weekMenu1.addDagMenu(new DagMenu(dagId.incrementAndGet(), "Donderdag", "21/02/2019", getGerecht("Spaghetti"), getGerecht("Tomatensoep"), getGerecht("Balletjes in tomatensaus")));
        weekMenu1.addDagMenu(new DagMenu(dagId.incrementAndGet(), "Vrijdag", "22/02/2019", getGerecht("Spaghetti"), getGerecht("Aspergesoep"), getGerecht("Pasta kip")));
        weekMenus.add(weekMenu1);

        WeekMenu weekMenu2 = new WeekMenu(weekId.incrementAndGet());
        weekMenu2.addDagMenu(new DagMenu(dagId.incrementAndGet(), "Dinsdag", "26/02/2019", getGerecht("Spaghetti"), getGerecht("Tomatensoep"), getGerecht("Vol au vent")));
        weekMenu2.addDagMenu(new DagMenu(dagId.incrementAndGet(), "Woensdag", "27/02/2019", getGerecht("Spaghetti"), getGerecht("Groentensoep"), getGerecht("Pasta scampi")));
        weekMenu2.addDagMenu(new DagMenu(dagId.incrementAndGet(), "Donderdag", "28/02/2019", getGerecht("Spaghetti"), getGerecht("Aspergesoep"), getGerecht("Vol au vent")));
        weekMenu2.addDagMenu(new DagMenu(dagId.incrementAndGet(), "Vrijdag", "01/03/2019", getGerecht("Spaghetti"), getGerecht("Aspergesoep"), getGerecht("Pasta kip")));
        weekMenus.add(weekMenu2);

    }

    public boolean addGerecht(Gerecht g) {
        if (g == null) throw new DBException("Invalid gerecht");
        if (gerechten.contains(g)) throw new DBException("Gerecht is already added");
        if (g.getId() == -1) {
            g.setId(CURRENT_ID);
            CURRENT_ID++;
        }
        return this.gerechten.add(g);
    }

    public boolean removeGerecht(Gerecht g) {
        if (g == null) throw new DBException("Invalid gerecht");
        return this.gerechten.remove(g);
    }

    public boolean updateGerecht(Gerecht g) {
        if (g == null) throw new DBException("Invalid gerecht");
        gerechten.set(getIndexById(g.getId()), g);
        return true;
    }

    public Gerecht getGerecht(String d) {
        for (Gerecht g : getGerechten()) {
            if (g.getDescription().equals(d)) {
                return g;
            }
        }
        throw new DBException("Gerecht not in db");
    }

    public List<Gerecht> getGerechten() {
        return this.gerechten;
    }

    public List<WeekMenu> getWeekMenus() {
        return this.weekMenus;
    }

    public Gerecht getGerechtById(int id) {
        for (Gerecht gerecht : gerechten) {
            if (gerecht.getId() == id) return gerecht;
        }
        throw new DBException("Gerecht not in db");
    }

    private int getIndexById(int id) {
        for (int i = 0; i < gerechten.size(); i++) {
            if (gerechten.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void removeById(int id) {
        removeGerecht(getGerechtById(id));
    }

    public boolean addDagMenu(DagMenu dagMenu){
        weekMenus.get(0).addDagMenu(dagMenu);
        return true;
    }
}
