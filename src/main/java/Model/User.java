package Model;

public abstract class User {
    protected String username;
    protected String password;
    protected int bookingLimit;
    protected int currentBookings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.currentBookings = 0;
        setBookingLimit();
    }

    public abstract void setBookingLimit();

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getCurrentBookings() {
        return currentBookings;
    }

    public int getBookingLimit() {
        return bookingLimit;
    }

    public void incrementBookings() {
        currentBookings++;
    }

    public void decrementBookings() {
        currentBookings--;
    }
}