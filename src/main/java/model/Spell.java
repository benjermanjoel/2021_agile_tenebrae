/*
* The Spell class is the model for spell objects.
* */

package model;

import java.io.Serializable;

public class Spell implements Serializable {
    private String name;
    private String level;
    private String school;
    private String casting;
    private String ritual;
    private String concentration;
    private String classes;

    public Spell(String name, String level, String school, String casting, String ritual, String concentration, String classes) {
        this.name = name;
        this.level = level;
        this.school = school;
        this.casting = casting;
        this.ritual = ritual;
        this.concentration = concentration;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCasting() {
        return casting;
    }

    public void setCasting(String casting) {
        this.casting = casting;
    }

    public String getRitual() {
        return ritual;
    }

    public void setRitual(String ritual) {
        this.ritual = ritual;
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
