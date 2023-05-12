package interfaces;

// Import required classes and libraries
import model.User;

/**
 * The Loadable interface represents an object that can receive load in the GCash ShareALoad application.
 * It defines the method 'receiveLoad'. More methods can be added in the future.
 */
public interface Loadable {
    void receiveLoad(User sender, double amount);
}
