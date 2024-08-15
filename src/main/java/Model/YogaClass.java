package Model;

import Model.Enum.Classtype;
import java.util.Date;

public class YogaClass extends FitnessClass {
    public YogaClass(String name, int capacity, Date schedule) {
        super(name, Classtype.YOGA, capacity, schedule);
    }
}
