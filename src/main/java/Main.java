import Implementation.BookingManager;
import Implementation.ClassManagement;
import Implementation.UserManagement;
import Model.Enum.Classtype;
import Model.FitnessClass;

import java.text.SimpleDateFormat;
import java.util.Date;

import static Model.Enum.Classtype.DANCE;
import static Model.Enum.Classtype.GYM;
import static Model.Enum.Classtype.YOGA;
import static Model.Enum.TierType.GOLD;
import static Model.Enum.TierType.PLATINUM;
import static Model.Enum.TierType.SILVER;

public class Main {
    public static void main(String[] args) throws Exception {
        BookingManager bookingManager = BookingManager.getInstance();
        UserManagement userManagement = UserManagement.getInstance();
        ClassManagement classManagement = ClassManagement.getInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date yogaClassDate = dateFormat.parse("2024-07-28 10:00");
        Date gymClassDate = dateFormat.parse("2024-07-28 12:00");
        Date danceClassDate = dateFormat.parse("2024-07-28 14:00");

        classManagement.createClass(YOGA, "Morning Yoga", 10, yogaClassDate);
        classManagement.createClass(GYM, "Dancing Class", 20, gymClassDate);
        classManagement.createClass(DANCE, "Workout", 15, danceClassDate);

        userManagement.registerUser("Shivam", "password123", GOLD);
        userManagement.registerUser("Mbappe", "password456", SILVER);
        userManagement.registerUser("Ronaldo", "password789", PLATINUM);

        bookingManager.bookClass("Shivam", "Morning Yoga");
        bookingManager.bookClass("Shraddha", "Morning Yoga");
        bookingManager.bookClass("Mbappe", "Dancing Class");
        bookingManager.bookClass("Ronaldo", "Workout");

        userManagement.registerUser("Shraddha", "password789", PLATINUM);
        bookingManager.bookClass("Shraddha", "Morning Yoga");

        FitnessClass morningYoga = classManagement.getClass("Morning Yoga");
        System.out.println("Morning Yoga Attendees: " + morningYoga.getAttendees().size());

        bookingManager.cancelBooking("Shivam", "Morning Yoga");
        System.out.println("Morning Yoga Attendees after cancellation: " + morningYoga.getAttendees().size());


//        for (int i = 0; i < 9; i++) {
//            bookingManager.bookClass("user" + i, "Morning Yoga");
//        }

        bookingManager.bookClass("Ronaldo", "Morning Yoga");
        System.out.println("Morning Yoga Attendees: " + morningYoga.getAttendees().size());
//        System.out.println("Morning Yoga Waitlist: " + morningYoga.getWaitlist().size());

        bookingManager.cancelBooking("Shraddha", "Morning Yoga");
        System.out.println("Morning Yoga Attendees: " + morningYoga.getAttendees().size());
//        System.out.println("Morning Yoga Waitlist: " + morningYoga.getWaitlist().size());
    }
}
