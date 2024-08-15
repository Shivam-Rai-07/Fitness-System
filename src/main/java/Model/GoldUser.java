package Model;

public class GoldUser extends User {
    public GoldUser(String username, String password) {
        super(username, password);
    }
    @Override
    public void setBookingLimit() {
        this.bookingLimit = 5;
    }
}
