package comparators;

import model.NPC;

import java.util.Comparator;

public class ComparatorNPC implements Comparator<NPC>{

    public int compare(NPC name1, NPC name2) {

        return name1.getName().compareTo(name2.getName());
    }
}