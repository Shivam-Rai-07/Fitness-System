package Model;

import Model.Enum.Classtype;

import java.util.Date;

public class DanceClass extends FitnessClass {
    public DanceClass(String name, int capacity, Date schedule) {
        super(name, Classtype.DANCE, capacity, schedule);
    }
}
