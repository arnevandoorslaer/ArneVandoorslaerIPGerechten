package be.ucll.gerecht.db;

import be.ucll.gerecht.model.DagMenu;
import be.ucll.gerecht.model.Gerecht;
import be.ucll.gerecht.model.WeekMenu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GerechtDB {
    private List<Gerecht> gerechten;
    private List<WeekMenu> weekMenus;
    private int CURRENT_ID = 1000;
    private AtomicInteger weekId = new AtomicInteger();
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

        weekMenus.add(new WeekMenu(weekId.incrementAndGet()));
        weekMenus.add(new WeekMenu(weekId.incrementAndGet()));

        addDagMenu(new DagMenu("Dinsdag", "19/02/2019", getGerecht("Spaghetti"), getGerecht("Aspergesoep"), getGerecht("Vol au vent")));
        addDagMenu(new DagMenu("Woensdag", "20/02/2019", getGerecht("Spaghetti"), getGerecht("Groentensoep"), getGerecht("Pasta scampi")));
        addDagMenu(new DagMenu("Donderdag", "21/02/2019", getGerecht("Spaghetti"), getGerecht("Tomatensoep"), getGerecht("Balletjes in tomatensaus")));
        addDagMenu(new DagMenu("Vrijdag", "22/02/2019", getGerecht("Spaghetti"), getGerecht("Aspergesoep"), getGerecht("Pasta kip")));
        addDagMenu(new DagMenu("Dinsdag", "26/02/2019", getGerecht("Spaghetti"), getGerecht("Tomatensoep"), getGerecht("Vol au vent")));
        addDagMenu(new DagMenu("Woensdag", "27/02/2019", getGerecht("Spaghetti"), getGerecht("Groentensoep"), getGerecht("Pasta scampi")));
        addDagMenu(new DagMenu("Donderdag", "28/02/2019", getGerecht("Spaghetti"), getGerecht("Aspergesoep"), getGerecht("Vol au vent")));
        addDagMenu(new DagMenu("Vrijdag", "01/03/2019", getGerecht("Spaghetti"), getGerecht("Aspergesoep"), getGerecht("Pasta kip")));


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

    public boolean addDagMenu(DagMenu dagMenu) {
        try {
            getWeekMenuByDatum(dagMenu.getDatum()).addDagMenu(dagMenu);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }


    public boolean updateDagMenu(DagMenu dg) throws ParseException {
        for (int i = 0; i < getWeekMenuByDatum(dg.getDatum()).getDagMenus().size(); i++) {
            if (getWeekMenuByDatum(dg.getDatum()).getDagMenus().get(i).getDatum().equals(dg.getDatum())) {
                getWeekMenuByDatum(dg.getDatum()).getDagMenus().set(i, dg);
                return true;
            }
        }
        return false;
    }

    public WeekMenu getWeekMenuByDatum(String datum) throws ParseException {
        for (WeekMenu weekmenu : weekMenus) {
            return weekmenu;
        }
        return null;
    }
}
