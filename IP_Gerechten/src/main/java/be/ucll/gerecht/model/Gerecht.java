package be.ucll.gerecht.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Gerecht {
    @NotNull
    @Size(min = 4, max = 50)
    private String description;
    private String type;
    @NotNull
    @DecimalMax("10.0")
    @DecimalMin("0.10")
    private double price;
    private int id = -1;

    public Gerecht(String d, double p, String t) {
        setDescription(d);
        setPrice(p);
        setType(t);
    }

    public Gerecht() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gerecht gerecht = (Gerecht) o;
        return id == gerecht.id ||
                Objects.equals(description, gerecht.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, id);
    }

    public int CompareTo(Object o) {
        if (this == o) return 0;
        Gerecht gerecht = (Gerecht) o;
        if (this.getId() > gerecht.getId()) {
            return 1;
        } else {
            return -1;
        }
    }


}
