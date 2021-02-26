package comparators;

import model.PC;

import java.util.Comparator;

public class ComparatorPC implements Comparator<PC>{

    public int compare(PC name1, PC name2) {

        return name1.getName().compareTo(name2.getName());
    }
}
