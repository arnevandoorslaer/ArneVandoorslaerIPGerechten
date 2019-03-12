package be.ucll.gerecht.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.*;
import java.util.Objects;

public class Gerecht {
    @NotEmpty(message = "Description can not be empty.")
    @Size(min = 4, max = 50,message = "Description length must be between 4 and 50.")
    private String description;
    private String type;
    @NotNull(message = "Price can not be empty.")
    @DecimalMax(value = "10.0",message = "Price can't be higher than 10.")
    @DecimalMin(value = "0.10",message = "Price can't be lower than 0.10.")
    private double price;
    @JsonIgnore
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

    public int compareTo(Object o) {
        if (this == o) return 0;
        Gerecht gerecht = (Gerecht) o;
        if (this.getId() > gerecht.getId()) {
            return 1;
        } else {
            return -1;
        }
    }


}
