package be.ucll.gerecht.db;

import be.ucll.gerecht.model.Gerecht;

import java.util.ArrayList;
import java.util.List;

public class GerechtDB {

    private List<Gerecht> gerechten;
    private int CURRENT_ID = 1000;

    public GerechtDB() {
        this.gerechten = new ArrayList<>();
        init();
    }

    private void init() {
        addGerecht(new Gerecht("Bitterballen", 1.5, "VEGGIE"));
        addGerecht(new Gerecht("Frikandel", 1.5, "VEGGIE"));
        addGerecht(new Gerecht("Boulet", 1.5, "VEGGIE"));
        addGerecht(new Gerecht("Cervela", 1.5, "VEGGIE"));
        addGerecht(new Gerecht("Frieten XL", 3, "SOEP"));
        addGerecht(new Gerecht("Frieten L", 2.5, "SOEP"));
        addGerecht(new Gerecht("Frieten M", 2, "SOEP"));
        addGerecht(new Gerecht("Frieten S", 1.75, "SOEP"));
        addGerecht(new Gerecht("Andalouse", 0.75, "SOEP"));
        addGerecht(new Gerecht("Joppie", 0.75, "DAGSCHOTEL"));
        addGerecht(new Gerecht("Ketchup", 0.75, "DAGSCHOTEL"));
        addGerecht(new Gerecht("Mayo", 0.75, "DAGSCHOTEL"));
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
        removeById(g.getId());
        return addGerecht(g);
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

    public Gerecht getGerechtById(int id) {
        for (Gerecht gerecht : gerechten) {
            if (gerecht.getId() == id) return gerecht;
        }
        throw new DBException("Gerecht not in db");
    }

    public void removeById(int id) {
        removeGerecht(getGerechtById(id));
    }
}
