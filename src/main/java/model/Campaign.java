package model;

import java.io.Serializable;

public class Campaign implements Serializable {
    private String name;
    private String race;
    private String char_class;

    // Constructors
    public Campaign(){

    }
    public Campaign(String name, String race, String char_class) {
        this.name = name;
        this.race = race;
        this.char_class = char_class;
    }
    // Getters 'n Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getChar_class() {
        return char_class;
    }

    public void setChar_class(String char_class) {
        this.char_class = char_class;
    }
}
