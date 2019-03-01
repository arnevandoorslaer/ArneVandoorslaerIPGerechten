package be.ucll.gerecht.db;

import be.ucll.gerecht.model.Gerecht;

import java.util.ArrayList;
import java.util.List;

public class GerechtDB {

    private List<Gerecht> gerechten;

    public GerechtDB() {
        this.gerechten = new ArrayList<>();
        init();
    }

    private void init(){
        addGerecht(new Gerecht("Bitterballen", 1.5));
        addGerecht(new Gerecht("Frikandel", 1.5));
        addGerecht(new Gerecht("Boulet", 1.5));
        addGerecht(new Gerecht("Cervela", 1.5));
        addGerecht(new Gerecht("Frieten XL", 3));
        addGerecht(new Gerecht("Frieten L", 2.5));
        addGerecht(new Gerecht("Frieten M", 2));
        addGerecht(new Gerecht("Frieten S", 1.75));
        addGerecht(new Gerecht("Andalouse", 0.75));
        addGerecht(new Gerecht("Joppie", 0.75));
        addGerecht(new Gerecht("Ketchup", 0.75));
        addGerecht(new Gerecht("Mayo", 0.75));
    }

    public boolean addGerecht(Gerecht g) {
        if (g == null) throw new DBException("Invalid gerecht");
        if (gerechten.contains(g)) throw new DBException("Gerecht is already added");
        this.gerechten.add(g);
        return false;
    }

    public boolean removeGerecht(Gerecht g) {
        if (g == null) throw new DBException("Invalid gerecht");
        return this.gerechten.remove(g);
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
}
