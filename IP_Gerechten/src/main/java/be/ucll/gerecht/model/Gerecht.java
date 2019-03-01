package be.ucll.gerecht.model;

import java.util.Objects;

public class Gerecht {

    private String description;
    private double price;
    private String type;

    public Gerecht(String d, double p, String t) {
        setDescription(d);
        setPrice(p);
        setType(t);
    }

    public Gerecht(String d, double p) {
        setDescription(d);
        setPrice(p);
    }

    public Gerecht() {

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
        if (description == null || description.trim().isEmpty()) {
            throw new DomainException("Please provide a description");
        }
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new DomainException("Please provide a valid price");
        }
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gerecht gerecht = (Gerecht) o;
        return Double.compare(gerecht.price, price) == 0 &&
                Objects.equals(description, gerecht.description) &&
                Objects.equals(type, gerecht.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price, type);
    }
}
