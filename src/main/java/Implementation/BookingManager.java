package Implementation;

import Model.FitnessClass;
import Model.User;

import java.util.Date;
import java.util.Queue;

public class BookingManager {
    private static volatile BookingManager instance;
    private final ClassManagement classManagement;
    private final UserManagement userManagement;

    private BookingManager() {
        classManagement = ClassManagement.getInstance();
        userManagement = UserManagement.getInstance();
    }

    public static BookingManager getInstance() {
        if (instance == null) {
            synchronized (BookingManager.class) {
                if (instance == null)
                    instance = new BookingManager();
            }
        }
        return instance;
    }

    public synchronized boolean bookClass(String username, String className) {
        User user = userManagement.getUser(username);
        if (user == null) {
            System.out.println("User not found: " + username);
            return false;
        }

        FitnessClass fitnessClass = classManagement.getClass(className);
        if (fitnessClass == null) {
            System.out.println("Class not found: " + className);
            return false;
        }

        if (user.getCurrentBookings() >= user.getBookingLimit()) {
            System.out.println("User has reached booking limit: " + username);
            return false;
        }

        if (fitnessClass.getCapacity() == fitnessClass.getAttendees().size()) {
            System.out.println("Class has reached booking limit: " + className);
            fitnessClass.addWaitlist(user);
            return false;
        }

        boolean added = fitnessClass.addAttendee(user);
        if (added) {
            user.incrementBookings();
        }
        return added;
    }

    public synchronized boolean cancelBooking(String username, String className) {
        User user = userManagement.getUser(username);
        if (user == null) {
            System.out.println("User not found: " + username);
            return false;
        }

        FitnessClass fitnessClass = classManagement.getClass(className);
        if (fitnessClass == null) {
            System.out.println("Class not found: " + className);
            return false;
        }

        Date now = new Date();
        if (now.after(new Date(fitnessClass.getSchedule().getTime() - 30 * 60 * 1000))) {
            System.out.println("Cannot cancel booking within 30 minutes of class start time: " + className);
            return false;
        }

        fitnessClass.removeAttendee(user);
        user.decrementBookings();

        Queue<User> waitListUsers = fitnessClass.getWaitlist();
        if(!waitListUsers.isEmpty()) {
            bookClass(user.getUsername(), className);
        }
        return true;
    }
}
