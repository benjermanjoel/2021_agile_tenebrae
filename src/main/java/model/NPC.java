/*
* The NPC class is the model for non-playable character objects.
* */

package model;

import java.io.Serializable;

public class NPC implements Serializable {
    private String name;
    private String type;
    private String char_class;
    private String level;
    private String race;
    private String hitpts;
    private String armor;
    private String proficiency;
    private String initiative;
    private String speed;
    private String strength;
    private String dexterity;
    private String constitution;
    private String intelligence;
    private String wisdom;
    private String charisma;
    private String location;
    private String traits;
    private String background;

    // Constructor

    public NPC(String name, String type, String char_class, String level, String race, String hitpts, String armor,
               String proficiency, String initiative, String speed, String strength, String dexterity,
               String constitution, String intelligence, String wisdom, String charisma, String location,
               String traits, String background) {
        this.name = name;
        this.type = type;
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
        this.location = location;
        this.traits = traits;
        this.background = background;
    }


    // Getters 'n setters


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

    public String getChar_class() {
        return char_class;
    }

    public void setChar_class(String char_class) {
        this.char_class = char_class;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getHitpts() {
        return hitpts;
    }

    public void setHitpts(String hitpts) {
        this.hitpts = hitpts;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public String getInitiative() {
        return initiative;
    }

    public void setInitiative(String initiative) {
        this.initiative = initiative;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getDexterity() {
        return dexterity;
    }

    public void setDexterity(String dexterity) {
        this.dexterity = dexterity;
    }

    public String getConstitution() {
        return constitution;
    }

    public void setConstitution(String constitution) {
        this.constitution = constitution;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getWisdom() {
        return wisdom;
    }

    public void setWisdom(String wisdom) {
        this.wisdom = wisdom;
    }

    public String getCharisma() {
        return charisma;
    }

    public void setCharisma(String charisma) {
        this.charisma = charisma;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTraits() {
        return traits;
    }

    public void setTraits(String traits) {
        this.traits = traits;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
