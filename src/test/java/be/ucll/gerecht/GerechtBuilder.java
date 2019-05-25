package be.ucll.gerecht;

import be.ucll.gerecht.model.Gerecht;

import java.util.concurrent.atomic.AtomicInteger;

public class GerechtBuilder {

    private int id;
    private String description;
    private String type;
    private double price;

    private AtomicInteger atomicInteger;

    private GerechtBuilder() {
        atomicInteger = new AtomicInteger(0);
    }

    public static GerechtBuilder getGerechtBuilder() {
        return new GerechtBuilder();
    }

    public GerechtBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public GerechtBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public GerechtBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public GerechtBuilder withID(int id) {
        this.id = id;
        return this;
    }
    public GerechtBuilder withID() {
        this.id = atomicInteger.incrementAndGet();
        System.out.println(id);
        return this;
    }

    public Gerecht build() {
        return new Gerecht(this.id, this.description, this.price, this.type);
    }
}
