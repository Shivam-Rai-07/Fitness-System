package Implementation;

import Model.DanceClass;
import Model.Enum.Classtype;
import Model.FitnessClass;
import Model.GymClass;
import Model.YogaClass;

import java.util.Date;

class ClassFactory {
    public static FitnessClass createClass(Classtype type, String name, int capacity, Date schedule) {
        return switch (type) {
            case YOGA -> new YogaClass(name, capacity, schedule);
            case GYM -> new GymClass(name, capacity, schedule);
            case DANCE -> new DanceClass(name, capacity, schedule);
            default -> throw new IllegalArgumentException("Invalid class type: " + type);
        };
    }
}
