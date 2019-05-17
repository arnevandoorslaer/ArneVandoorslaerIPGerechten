package be.ucll.gerecht.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class DagMenu implements Serializable {
    private String dag;
    @Id
    private String datum;
    @OneToOne(cascade= CascadeType.ALL)
    private Gerecht veggie,soep,dagschotel;


    public DagMenu(String dag, String datum, Gerecht veggie, Gerecht soep, Gerecht dagschotel) {
        addDagschotel(dagschotel);
        addVeggie(veggie);
        addSoep(soep);

        setDag(dag);
        setDatum(datum);
    }


    public DagMenu(){}

    public void addVeggie(Gerecht gerecht) {
        this.veggie = gerecht;
    }

    public void addSoep(Gerecht gerecht) {
        this.soep = gerecht;
    }

    public void addDagschotel(Gerecht gerecht) {
        this.dagschotel = gerecht;
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

    public void setVeggie(Gerecht veggie) {
        this.veggie = veggie;
    }

    public void setSoep(Gerecht soep) {
        this.soep = soep;
    }

    public void setDagschotel(Gerecht dagschotel) {
        this.dagschotel = dagschotel;
    }

    @Override
    public String toString() {
        return "DagMenu{" +
                ", dag='" + dag + '\'' +
                ", datum='" + datum + '\'' +
                ", veggie=" + veggie +
                ", soep=" + soep +
                ", dagschotel=" + dagschotel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DagMenu dagMenu = (DagMenu) o;

        if (getDag() != null ? !getDag().equals(dagMenu.getDag()) : dagMenu.getDag() != null) return false;
        if (getDatum() != null ? !getDatum().equals(dagMenu.getDatum()) : dagMenu.getDatum() != null) return false;
        if (getVeggie() != null ? !getVeggie().equals(dagMenu.getVeggie()) : dagMenu.getVeggie() != null) return false;
        if (getSoep() != null ? !getSoep().equals(dagMenu.getSoep()) : dagMenu.getSoep() != null) return false;
        return getDagschotel() != null ? getDagschotel().equals(dagMenu.getDagschotel()) : dagMenu.getDagschotel() == null;
    }

    @Override
    public int hashCode() {
        int result = getDag() != null ? getDag().hashCode() : 0;
        result = 31 * result + (getDatum() != null ? getDatum().hashCode() : 0);
        result = 31 * result + (getVeggie() != null ? getVeggie().hashCode() : 0);
        result = 31 * result + (getSoep() != null ? getSoep().hashCode() : 0);
        result = 31 * result + (getDagschotel() != null ? getDagschotel().hashCode() : 0);
        return result;
    }
}
