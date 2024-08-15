package Model;

import Model.Enum.Classtype;

import java.util.Date;

public class GymClass extends FitnessClass {
    public GymClass(String name, int capacity, Date schedule) {
        super(name, Classtype.GYM, capacity, schedule);
    }
}
