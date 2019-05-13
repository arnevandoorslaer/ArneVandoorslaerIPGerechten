package be.ucll.gerecht.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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

}
