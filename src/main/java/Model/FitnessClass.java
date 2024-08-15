package Model;

import Model.Enum.Classtype;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class FitnessClass {
    protected String name;
    protected Classtype type;
    protected int capacity;
    protected Date schedule;
    protected List<User> attendees;
    protected Queue<User> waitlist;

    public FitnessClass(String name, Classtype type, int capacity, Date schedule) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.schedule = schedule;
        this.attendees = new ArrayList<>();
        this.waitlist = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public Classtype getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public Date getSchedule() { return schedule; }

    public List<User> getAttendees() {
        return attendees;
    }

    public Queue<User> getWaitlist() {
        return waitlist;
    }

    public boolean addAttendee(User user) {
        if (attendees.size() < capacity) {
            attendees.add(user);
            return true;
        }
        return false;
    }

    public void removeAttendee(User user) {
        attendees.remove(user);
    }

    public void addWaitlist(User user) {
        waitlist.add(user);
    }
}
