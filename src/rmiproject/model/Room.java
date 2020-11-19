package rmiproject.model;

import java.io.Serializable;

public class Room implements Serializable {
    private static final long serialVersionUID = 6529685098267757692L;
    private int id;
    private String name;
    private int price;
    private String description;

    public Room(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
