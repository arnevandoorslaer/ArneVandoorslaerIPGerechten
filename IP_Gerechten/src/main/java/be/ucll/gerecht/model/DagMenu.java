package be.ucll.gerecht.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DagMenu {
    @JsonIgnore
    private int id = 0;
    private String dag;
    private String datum;
    private Gerecht[] gerechten;

    public DagMenu(int id, String dag, String datum, Gerecht veggie, Gerecht soep, Gerecht dagschotel) {
        gerechten = new Gerecht[3];
        setId(id);
        addDagschotel(dagschotel);
        addVeggie(veggie);
        addSoep(soep);

        setDag(dag);
        setDatum(datum);
    }

    public void addVeggie(Gerecht gerecht) {
        gerechten[0] = gerecht;
    }

    public void addSoep(Gerecht gerecht) {
        gerechten[1] = gerecht;
    }

    public void addDagschotel(Gerecht gerecht) {
        gerechten[2] = gerecht;
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
        return gerechten[0];
    }

    public Gerecht getSoep() {
        return gerechten[1];
    }

    public Gerecht getDagschotel() {
        return gerechten[2];
    }
}
