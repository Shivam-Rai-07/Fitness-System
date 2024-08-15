package Model;

public class PlatinumUser extends User {
    public PlatinumUser(String username, String password) {
        super(username, password);
    }
    @Override
    public void setBookingLimit() {
        this.bookingLimit = 10;
    }
}