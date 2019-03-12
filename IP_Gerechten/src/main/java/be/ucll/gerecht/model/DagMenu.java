package be.ucll.gerecht.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DagMenu {
    @JsonIgnore
    private int id = 0;
    private String dag;
    private String datum;
    private Gerecht veggie,soep,dagschotel;

    public DagMenu(int id, String dag, String datum, Gerecht veggie, Gerecht soep, Gerecht dagschotel) {
        setId(id);
        addDagschotel(dagschotel);
        addVeggie(veggie);
        addSoep(soep);

        setDag(dag);
        setDatum(datum);
    }

    public void addVeggie(Gerecht gerecht) {
        this.veggie = gerecht;
    }

    public void addSoep(Gerecht gerecht) {
        this.soep = gerecht;
    }

    public void addDagschotel(Gerecht gerecht) {
        this.dagschotel = gerecht;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return this.veggie;
    }

    public Gerecht getSoep() {
        return this.soep;
    }

    public Gerecht getDagschotel() {
        return this.dagschotel;
    }
}
