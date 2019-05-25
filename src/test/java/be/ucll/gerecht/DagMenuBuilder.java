package be.ucll.gerecht;

import be.ucll.gerecht.model.DagMenu;
import be.ucll.gerecht.model.Gerecht;

public class DagMenuBuilder {

    private String dag;
    private String datum;
    private Gerecht veggie, soep, dagschotel;

    private GerechtBuilder gerechtBuilder;

    private DagMenuBuilder() {
        gerechtBuilder = GerechtBuilder.getGerechtBuilder();
    }

    public static DagMenuBuilder getDagMenuBuilder() {
        return new DagMenuBuilder();
    }

    public DagMenuBuilder withAnOkDagschotel() {
        this.dagschotel = gerechtBuilder.withID().withDescription("DAGSCHOTEL").withPrice(3).withType("DAGSCHOTEL").build();
        return this;
    }

    public DagMenuBuilder withAnOkSoep() {
        this.soep = gerechtBuilder.withID().withDescription("SOEP").withPrice(1).withType("SOEP").build();
        return this;
    }

    public DagMenuBuilder withAnOkVeggie() {
        this.veggie = gerechtBuilder.withID().withDescription("VEGGIE").withPrice(4).withType("VEGGIE").build();
        return this;
    }

    public DagMenuBuilder withDag(String dag) {
        this.dag = dag;
        return this;
    }

    public DagMenuBuilder withDatum(String datum) {
        this.datum = datum;
        return this;
    }

    public DagMenuBuilder withVeggie(Gerecht veggie) {
        this.veggie = veggie;
        return this;
    }

    public DagMenuBuilder withDagschotel(Gerecht dagschotel) {
        this.dagschotel = dagschotel;
        return this;
    }

    public DagMenuBuilder withSoep(Gerecht soep) {
        this.soep = soep;
        return this;
    }

    public DagMenu build() {
        return new DagMenu(dag, datum, veggie, soep, dagschotel);
    }
}
