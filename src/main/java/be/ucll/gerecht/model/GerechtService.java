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

    public WeekMenu getWeekMenu(int id){
        return this.weekMenuRepository.findWeekMenuById(id);
    }

    public WeekMenu addDagMenu(DagMenu dg) {
        int weekId = DateConverter.GetWeekNrFromString(dg.getDatum());
        WeekMenu temp = this.weekMenuRepository.findWeekMenuById(weekId);
        if (temp == null) {
            this.weekMenuRepository.save(new WeekMenu(weekId));
        }
        temp = this.weekMenuRepository.findWeekMenuById(weekId);
        temp.addDagMenu(dg);
        weekMenuRepository.save(temp);
        return temp;
    }

    public void removeDagMenu(DagMenu dg) {
        int weekId = DateConverter.GetWeekNrFromString(dg.getDatum());
        WeekMenu temp = this.weekMenuRepository.findWeekMenuById(weekId);
        temp.removeDagMenu(dg);
        weekMenuRepository.save(temp);
    }

    public WeekMenu updateDagMenu(DagMenu dg) {
        int weekId = DateConverter.GetWeekNrFromString(dg.getDatum());
        WeekMenu temp = this.weekMenuRepository.findWeekMenuById(weekId);
        if (temp == null) {
            this.weekMenuRepository.save(new WeekMenu(weekId));
        }
        temp = this.weekMenuRepository.findWeekMenuById(weekId);
        temp.updateDagMenu(dg);
        weekMenuRepository.save(temp);
        return temp;
    }

    public boolean checkIfGerechtExists(String description) {
        Gerecht gerecht = this.gerechtRepository.findByDescription(description);
        System.out.println(gerecht);
        return gerecht == null;
    }
}
