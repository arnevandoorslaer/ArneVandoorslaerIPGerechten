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

    public Gerecht getGerecht(String d) {
        return this.gerechtDB.getGerecht(d);
    }

    public boolean addGerecht(Gerecht g) {
        return this.gerechtDB.addGerecht(g);
    }

    public boolean removeGerecht(Gerecht g){
        return this.gerechtDB.removeGerecht(g);
    }


}
