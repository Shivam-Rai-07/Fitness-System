package Implementation;

import Model.Enum.Classtype;
import Model.FitnessClass;
import Model.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassManagement {
    private static volatile ClassManagement instance;
    private ClassSchedule classSchedule;
    private Map<String, FitnessClass> classes;

    private ClassManagement() {
        classSchedule = new ClassSchedule();
        classes = new HashMap<>();
    }

    public static ClassManagement getInstance() {
        if (instance == null) {
            synchronized (ClassManagement.class) {
                if (instance == null)
                    instance = new ClassManagement();
            }
        }
        return instance;
    }

    public void createClass(Classtype type, String name, int capacity, Date schedule) {
        FitnessClass fitnessClass = ClassFactory.createClass(type, name, capacity, schedule);
        classes.put(name, fitnessClass);
        classSchedule.addClass(fitnessClass);
    }

    public void cancelClass(String name) {
        FitnessClass fitnessClass = classes.remove(name);
        if (fitnessClass != null) {
            classSchedule.removeClass(fitnessClass);
            fitnessClass.getAttendees().forEach(User::decrementBookings);
        }
    }

    public FitnessClass getClass(String name) {
        return classes.get(name);
    }

    public List<FitnessClass> getClassesByDate(Date date) {
        return classSchedule.getClassesByDate(date);
    }
}
