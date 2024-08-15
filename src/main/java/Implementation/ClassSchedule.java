package Implementation;

import Model.FitnessClass;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ClassSchedule {
    private final HashMap<Date, List<FitnessClass>> schedule;

    public ClassSchedule() {
        schedule = new HashMap<>();
    }

    public void addClass(FitnessClass fitnessClass) {
        Date classDate = fitnessClass.getSchedule();
        if (!schedule.containsKey(classDate)) {
            schedule.put(classDate, new ArrayList<>());
        }
        schedule.get(classDate).add(fitnessClass);
    }

    public List<FitnessClass> getClassesByDate(Date date) {
        return schedule.getOrDefault(date, new ArrayList<>());
    }

    public void removeClass(FitnessClass fitnessClass) {
        Date classDate = fitnessClass.getSchedule();
        List<FitnessClass> classes = schedule.get(classDate);
        if (classes != null) {
            classes.remove(fitnessClass);
            if (classes.isEmpty()) {
                schedule.remove(classDate);
            }
        }
    }
}
