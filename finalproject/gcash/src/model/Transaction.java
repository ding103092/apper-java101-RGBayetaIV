package model;

// Import required classes and libraries
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a transaction in the GCash ShareALoad application.
 * A transaction consists of a sender, a recipient, an amount, and a timestamp.
 * Stores User objects for both sender and recipient, allowing easy access to their details.
 */
public class Transaction {
    private final User sender;
    private final User recipient;
    private final double amount;
    private final LocalDateTime timestamp;

    public Transaction(User sender, User recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    //----------------------------------------------------------------
    // Getters and Setters
    //----------------------------------------------------------------

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * @return The String representation of instance Transaction
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("Transaction{%s}: Sender: %s, Recipient: %s, Amount: %.2f",
                timestamp.format(formatter), sender.getMobileNumber(), recipient.getMobileNumber(), amount);
    }
}