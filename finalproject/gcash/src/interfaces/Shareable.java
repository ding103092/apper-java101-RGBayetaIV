package interfaces;

// Import required classes and libraries
import model.User;
/**
 * The Shareable interface represents an object that can share load in the GCash application.
 * It defines the method 'shareLoad'. More methods can be added in the future.
 */
public interface Shareable {
    boolean sendLoad(User recipient, double amount);
}
