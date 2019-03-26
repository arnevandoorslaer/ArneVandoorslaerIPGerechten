package be.ucll.gerecht.model;

import be.ucll.gerecht.db.GerechtDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerechtService {

    private GerechtDB gerechtDB;

    public GerechtService() {
        this.gerechtDB = new GerechtDB();
    }

    public List<Gerecht> getGerechten() {
        return this.gerechtDB.getGerechten();
    }

    public List<WeekMenu> getWeekMenus() {
        return this.gerechtDB.getWeekMenus();
    }

    public Gerecht getGerecht(String d) {
        return this.gerechtDB.getGerecht(d);
    }

    public Gerecht getGerechtById(int id) {
        return this.gerechtDB.getGerechtById(id);
    }

    public boolean addGerecht(Gerecht g) {
        return this.gerechtDB.addGerecht(g);
    }

    public boolean updateGerecht(Gerecht g) {
        return this.gerechtDB.updateGerecht(g);
    }

    public boolean removeGerecht(Gerecht g) {
        return this.gerechtDB.removeGerecht(g);
    }

    public boolean addDagMenu(DagMenu dg){
        return this.gerechtDB.addDagMenu(dg);
    }
}