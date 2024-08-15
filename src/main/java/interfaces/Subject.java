package interfaces;

import java.util.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

    // Unable to implement observer pattern for waitlist Users due to time constraint
}