package services;

// Import required classes and libraries
import model.UserRole;
import model.User;
import model.Transaction;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

/**
 * GCashShareALoad is the main service class responsible for managing the application logic.
 * It maintains a map of users and provides methods for user registration, load sharing,
 * and displaying the transaction history of users.
 * It also provides utility methods for user validation and balance updates.
 */
public class GCashShareALoad {
    private Map<String, User> users;
    private List<Transaction> transactions;

    public GCashShareALoad() {
        this.users = new HashMap<>();
        this.transactions = new ArrayList<>();
    }

    /**
     * Used for getting an instance of User within GCashShareALoad
     * @param mobileNumber The mobile number to be searched
     * @return The user associated with the given mobileNumber
     */
    public Optional<User> findUserByMobileNumber(String mobileNumber) {
        User user = users.get(mobileNumber);
        return Optional.ofNullable(user);
    }

    /**
     * Register a new user with GCashShareALoad
     * @param mobileNumber the mobile number to be registered
     * @param name the name of the user
     * @param balance the balance of the user, default value = 100.00
     * @param userRole the role of the user within the app
     * @return if the user has successfully registered with GCashShareALoad
     */
    public boolean registerUser(String mobileNumber, String name, double balance, UserRole userRole) {
        try {
            // For error handling
            if (!isMobileNumberValid(mobileNumber)) throw new InvalidUserFieldException("Invalid mobile number");
            if (!isNameValid(name))                 throw new InvalidUserFieldException("Invalid name");
            if (balance < 0)                        throw new InvalidUserFieldException("Invalid balance");
            if (isRegistered(mobileNumber))         throw new UserAlreadyRegisteredException("User already registered");
            users.put(mobileNumber,  new User(mobileNumber, name, balance, userRole));
            return true;
        } catch(InvalidUserFieldException | UserAlreadyRegisteredException e) {
            System.out.printf("%s: Failed to register user due to %s\n", e.getClass().getSimpleName(), e.getMessage());
            return false;
        }
    }

    /**
     * Handles the sharing of load between sender and receiver
     * @param senderMobileNumber the mobile number of the sender
     * @param recipientMobileNumber the mobile number of recipient
     * @param amount the amount to be transferred
     */
    public void shareLoad(String senderMobileNumber, String recipientMobileNumber, double amount) {
        Optional<User> sender    = findUserByMobileNumber(senderMobileNumber);
        Optional<User> recipient = findUserByMobileNumber(recipientMobileNumber);

        try {
            // For error handling
            if (sender.isEmpty()) {
                throw new IllegalArgumentException("Sender is not present");
            }

            if (recipient.isEmpty()) {
                throw new IllegalArgumentException("Recipient is not present");
            }

            if (!isRegistered(senderMobileNumber)) {
                throw new SenderMobileNumberNotRegisteredException("Sender is not registered");
            }

            if (!isRegistered(recipientMobileNumber)) {
                throw new RecipientMobileNumberNotRegisteredException("Recipient is not registered");
            }

            if (senderMobileNumber.equals(recipientMobileNumber)) {
                throw new InvalidShareALoadTransactionException("Sender and Recipient cannot be the same");
            }

            if (sender.get().getBalance() < amount) {
                throw new InsufficientBalanceException("Insufficient balance");
            }

            // The actual transfer happens here
            sender.get().sendLoad(recipient.get(), amount);
            recipient.get().receiveLoad(sender.get(), amount);
            addTransaction(new Transaction(sender.get(), recipient.get(), amount));
            System.out.printf("Amount of %.2f was SUCCESSFULLY loaded to %s (%s) from %s (%s)\n",amount,recipientMobileNumber,
                    recipient.get().getName(),senderMobileNumber,sender.get().getName());


        } catch (IllegalArgumentException
                 | SenderMobileNumberNotRegisteredException
                 | RecipientMobileNumberNotRegisteredException
                 | InvalidShareALoadTransactionException
                 | InsufficientBalanceException e) {
            System.out.printf("%s: Failed to share load due to %s\n", e.getClass().getSimpleName(), e.getMessage());
        }
    }

    /**
     * Check if a mobile number is valid (09XXXXXXXXX) format
     * @param mobileNumber The mobile number to be checked
     * @return The validity of the mobile number
     */
    private boolean isMobileNumberValid(String mobileNumber) {
        return mobileNumber != null && mobileNumber.matches("^09\\d{9}$");
    }

    /**
     * Checks if name is valid
     * @param name The name to be checked
     * @return The validity of the name
     */
    private boolean isNameValid(String name) {
        return name != null && !name.trim().isEmpty();
    }

    /**
     * Checks if the mobile number is already registered
     * @param mobileNumber The mobile number to be checked
     * @return True if the mobile number is already registered
     */
    public boolean isRegistered(String mobileNumber) {
        return users.containsKey(mobileNumber);
    }

    /**
     * Adds transaction to the list of transactions
     * @param transaction The transaction to be added to the app data
     */
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    /**
     * Displays all users registered in the app
     * Also displays the balance of the users
     */
    public void displayAllUsers() {
        System.out.println("Current Registered Users: ");
        for (Map.Entry<String, User> entry : users.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


    /**
     * Displays the transaction history of the app
     */
    public void displayTransactionHistory() {
        System.out.println("Every Transaction History: ");
        transactions.forEach(System.out::println);
    }

    //----------------------------------------------------------------
    // Custom Exception classes
    //----------------------------------------------------------------
    public static class InvalidShareALoadTransactionException extends Exception {
        public InvalidShareALoadTransactionException( String message ) {
            super(message);
        }
    }

    public static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }

    public static class SenderMobileNumberNotRegisteredException extends Exception {
        public SenderMobileNumberNotRegisteredException(String message) {
            super(message);
        }
    }

    public static class RecipientMobileNumberNotRegisteredException extends Exception {
        public RecipientMobileNumberNotRegisteredException(String message) {
            super(message);
        }
    }

    public static class UserAlreadyRegisteredException extends Exception {
        public UserAlreadyRegisteredException(String message) {
           super(message);
        }
    }

    public static class InvalidUserFieldException extends Exception {
        public InvalidUserFieldException(String message) {
            super(message);
        }
    }
}