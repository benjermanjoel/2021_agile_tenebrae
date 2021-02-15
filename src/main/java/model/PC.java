/*
* The PC class is the model for playable character objects.
* */

package model;

import java.io.Serializable;

public class PC implements Serializable {
    private String name;
    private String char_class;
    private double level;
    private String race;
    private double hitpts;
    private double armor;
    private double proficiency;
    private double initiative;
    private double speed;
    private double strength;
    private double dexterity;
    private double constitution;
    private double intelligence;
    private double wisdom;
    private double charisma;
    private String background;
    
    // Constructor

    public PC(String name, String char_class, double level, String race, double hitpts, double armor, double proficiency, double initiative, double speed, double strength, double dexterity, double constitution, double intelligence, double wisdom, double charisma, String background) {
        this.name = name;
        this.char_class = char_class;
        this.level = level;
        this.race = race;
        this.hitpts = hitpts;
        this.armor = armor;
        this.proficiency = proficiency;
        this.initiative = initiative;
        this.speed = speed;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.background = background;
    }

    // Getters 'n setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChar_class() {
        return char_class;
    }

    public void setChar_class(String char_class) {
        this.char_class = char_class;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public double getHitpts() {
        return hitpts;
    }

    public void setHitpts(double hitpts) {
        this.hitpts = hitpts;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getProficiency() {
        return proficiency;
    }

    public void setProficiency(double proficiency) {
        this.proficiency = proficiency;
    }

    public double getInitiative() {
        return initiative;
    }

    public void setInitiative(double initiative) {
        this.initiative = initiative;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getDexterity() {
        return dexterity;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public double getConstitution() {
        return constitution;
    }

    public void setConstitution(double constitution) {
        this.constitution = constitution;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getWisdom() {
        return wisdom;
    }

    public void setWisdom(double wisdom) {
        this.wisdom = wisdom;
    }

    public double getCharisma() {
        return charisma;
    }

    public void setCharisma(double charisma) {
        this.charisma = charisma;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
    
}
