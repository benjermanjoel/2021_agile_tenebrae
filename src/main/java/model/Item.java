/*
* The Item class is the model for item objects.
* */

package model;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private String type;
    private String cost;
    private String weight;

    public Item(String name, String type, String cost, String weight) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
