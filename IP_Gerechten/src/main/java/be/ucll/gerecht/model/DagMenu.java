package be.ucll.gerecht.model;

import java.time.LocalDate;
import java.util.Date;

public class DagMenu {
    private Gerecht veggie;
    private Gerecht soep;
    private Gerecht dagschotel;
    private String dag;
    private String datum;

    public DagMenu(String dag, String datum,Gerecht veggie, Gerecht soep, Gerecht dagschotel) {
        setSoep(soep);
        setVeggie(veggie);
        setDagschotel(dagschotel);
        setDag(dag);
        setDatum(datum);
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getDag() {
        return dag;
    }

    public void setDag(String dag) {
        this.dag = dag;
    }

    public Gerecht getVeggie() {
        return veggie;
    }

    public void setVeggie(Gerecht veggie) {
        this.veggie = veggie;
    }

    public Gerecht getSoep() {
        return soep;
    }

    public void setSoep(Gerecht soep) {
        this.soep = soep;
    }

    public Gerecht getDagschotel() {
        return dagschotel;
    }

    public void setDagschotel(Gerecht dagschotel) {
        this.dagschotel = dagschotel;
    }
}
