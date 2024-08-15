package Model;

public class SilverUser extends User {
    public SilverUser(String username, String password) {
        super(username, password);
    }
    @Override
    public void setBookingLimit() {
        this.bookingLimit = 3;
    }
}
