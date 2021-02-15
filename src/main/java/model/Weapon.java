/*
* The Weapon class is the model used for weapon objects.
* */

package model;

import java.io.Serializable;

public class Weapon implements Serializable {
    private String name;
    private String type;
    private String cost;
    private String damage;
    private String weight;
    private String properties;

    public Weapon(String name, String type, String cost, String damage, String weight, String properties) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.damage = damage;
        this.weight = weight;
        this.properties = properties;
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

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
