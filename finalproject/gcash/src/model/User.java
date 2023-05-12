package model;

// Import required classes and libraries
import interfaces.Loadable;
import interfaces.Shareable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user in the GCash application.
 * A user has a name, balance, mobileNumber, userRole, and transaction
 * Implements the Shareable and Loadable interfaces, allowing users to share and receive load.
 */
public class User implements Shareable, Loadable {
    private String name;
    private double balance;
    private String mobileNumber;
    private UserRole userRole;
    private List<Transaction> transactions;

    //----------------------------------------------------------------
    // Constructor
    //----------------------------------------------------------------
    public User(String mobileNumber, String name, double balance, UserRole userRole) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.balance = balance;
        this.userRole = userRole;
        this.transactions = new ArrayList<>();
    }

    //----------------------------------------------------------------
    // Getters and Setters
    //----------------------------------------------------------------
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public UserRole getRole() { return userRole; }
    public void setRole(UserRole userRole) { this.userRole = userRole; }

    public List<Transaction> getTransactions() { return this.transactions; }
    public void addTransaction(Transaction transaction) { this.transactions.add(transaction); }

    //----------------------------------------------------------------
    // User functions (send and receive load)
    //----------------------------------------------------------------

    /**
     * Sends x amount of money from this user to the recipient
     * Balance is being updated accordingly, given a successful transaction
     * @param recipient The recipient of the load
     * @param amount The amount to be sent
     * @return If the transfer is successful
     */
    @Override
    public boolean sendLoad(User recipient, double amount) {
        if (this.balance >= amount && !this.mobileNumber.equals(recipient.getMobileNumber())) {
            this.balance -= amount;
            this.addTransaction(new Transaction(this, recipient, amount));
            return true;
        }
        return false;
    }

    /**
     * Receive x amount of money from another user
     * Balance is being updated accordingly, given a successful transaction
     * @param sender The sender of the load
     * @param amount The amount to be received
     */
    @Override
    public void receiveLoad(User sender, double amount) {
        this.balance += amount;
        this.addTransaction(new Transaction(sender, this, amount));
    }

    /**
     * @return The String representation of instance User
     */
    @Override
    public String toString() {
        return "User{" +
                "mobileNumber='" + mobileNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
