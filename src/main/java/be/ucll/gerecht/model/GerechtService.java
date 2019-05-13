package be.ucll.gerecht.model;

import be.ucll.gerecht.repository.GerechtRepository;
import be.ucll.gerecht.repository.WeekMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GerechtService {

    @Autowired
    WeekMenuRepository weekMenuRepository;

    @Autowired
    GerechtRepository gerechtRepository;

     public GerechtService() {

    }


    public List<Gerecht> getGerechten() {
        return this.gerechtRepository.findAll();
    }

    public List<WeekMenu> getWeekMenus() {
        return this.weekMenuRepository.findAll();
    }

    public Gerecht getGerecht(String d) {
        return this.gerechtRepository.findByDescription(d);
    }

    public Gerecht getGerechtById(int id) {
        return this.gerechtRepository.findById(id);
    }

    public Gerecht addGerecht(Gerecht g) {
        return this.gerechtRepository.save(g);
    }

    public Gerecht updateGerecht(Gerecht g) {
        return this.gerechtRepository.save(g);
    }

    public void removeGerecht(Gerecht g) {
        this.gerechtRepository.delete(g);
    }

    public void addDagMenu(DagMenu dg){
        int weekId = DateConverter.GetWeekNrFromString(dg.getDatum());
        if(this.weekMenuRepository.findWeekMenuById(weekId) == null){
            this.weekMenuRepository.save(new WeekMenu(weekId));
        }
        this.weekMenuRepository.findWeekMenuById(weekId).addDagMenu(dg);
    }

    public void updateDagMenu(DagMenu dg) {
        int weekId = DateConverter.GetWeekNrFromString(dg.getDatum());
        this.weekMenuRepository.findWeekMenuById(weekId).removeDagMenu(dg);
    }

    public void removeDagMenu(DagMenu dg) {
        int weekId = DateConverter.GetWeekNrFromString(dg.getDatum());
        if(this.weekMenuRepository.findWeekMenuById(weekId) == null){
            this.weekMenuRepository.save(new WeekMenu(weekId));
        }
        this.weekMenuRepository.findWeekMenuById(weekId).updateDagMenu(dg);
    }
}
