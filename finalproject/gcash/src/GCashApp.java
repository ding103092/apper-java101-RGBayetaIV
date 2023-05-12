// Import required classes and libraries
import model.Transaction;
import services.GCashShareALoad;
import java.util.List;
import java.util.Scanner;
import model.Const;
import model.UserRole;

/**
 * GCashApp is the main entry point of the application.
 * It initializes the GCashService and provides a text-based user interface for interaction.
 * Users can register, share load, and view their transaction history through this interface.
 */
public class GCashApp {
    // Initialize variables
    private static GCashShareALoad GCashShareLoad = new GCashShareALoad();
    private static Scanner scanner = new Scanner(System.in);
    private static int state = 1; // 1 for default, 2 for user page, 3 for admin
    private static boolean inSession = true; // The app runs while session is active
    private static String currentUser;
    public static void main(String[] args) {
        // Register initial users (non-negotiable requirement)
        GCashShareLoad.registerUser("09175861661", "Bob",100, UserRole.USER);
        GCashShareLoad.registerUser("09175861662", "Marley",100, UserRole.USER);
        GCashShareLoad.registerUser("09175861663", "Seth",100, UserRole.USER);
        GCashShareLoad.registerUser("09175861664", "Ryan",100, UserRole.USER);
        GCashShareLoad.registerUser("09175861665", "Fritz",100, UserRole.USER);
        GCashShareLoad.registerUser("09999999999","ADMIN",100,UserRole.ADMIN);

        // Program proper
        while (inSession) {
            int choice;
            switch (state) {
                // Handles the activity within the landing page (default)
                case Const.STATE_LANDING_PAGE -> {
                    choice = displayLandingPage();
                    switch (choice) {
                        case Const.REGISTER_USER -> {
                            System.out.print("Enter your mobile number: ");
                            String mobileNumber = scanner.next();
                            System.out.print("Enter your name: ");
                            String name = scanner.next();
                            if(GCashShareLoad.registerUser(mobileNumber.trim(), name, 100, UserRole.USER)) {
                                currentUser = mobileNumber;
                                state = Const.STATE_USER_PAGE;
                            }
                        }
                        case Const.LOGIN_USER -> {
                            System.out.print("Enter your mobile number: ");
                            String mobileNumber = scanner.next();
                            if(GCashShareLoad.isRegistered(mobileNumber)) {
                                currentUser = mobileNumber;
                                state = switch(GCashShareLoad.findUserByMobileNumber(currentUser).get().getRole()) {
                                    case USER -> Const.STATE_USER_PAGE;
                                    case ADMIN -> Const.STATE_ADMIN_PAGE;
                                };
                            } else System.out.println("User not registered.");
                        }
                        case Const.EXIT -> {
                            System.out.println("Program exiting...");
                            System.out.println("Thanks for using Share-a-Load!");
                            System.out.println("----------------------------------------");
                            inSession = false;
                        }
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                }
                // Handles the activity within the user page, requires registered mobile number
                case Const.STATE_USER_PAGE -> {
                    double balance = GCashShareLoad.findUserByMobileNumber(currentUser).get().getBalance();
                    choice = displayUserPage(GCashShareLoad.findUserByMobileNumber(currentUser).get().getName(),balance);
                    switch (choice) {
                        case Const.SHARE_LOAD -> {
                            System.out.print("Enter your recipient's mobile number: ");
                            String mobileNumber = scanner.next();
                            System.out.print("Enter the amount to be sent: ");
                            double amount = scanner.nextDouble();
                            GCashShareLoad.shareLoad(currentUser,mobileNumber.trim(), amount);
                        }
                        case Const.VIEW_MY_TRANSACTION_HISTORY -> {
                            List<Transaction> transaction = GCashShareLoad.findUserByMobileNumber(currentUser).get().getTransactions();
                            displayUserTransaction(transaction,GCashShareLoad.findUserByMobileNumber(currentUser).get().getName());
                        }
                        case Const.EXIT -> {
                            System.out.println("Program exiting...");
                            System.out.println("Thanks for using Share-a-Load!");
                            System.out.println("----------------------------------------");
                            inSession = false;
                        }
                        case Const.LOGOUT -> {
                            System.out.println("Successfully logged out...");
                            state = Const.STATE_LANDING_PAGE;
                        }
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                }
                // Handles the activity within the admin page, requires registered mobile number
                case Const.STATE_ADMIN_PAGE -> {
                    choice = displayAdminPage(GCashShareLoad.findUserByMobileNumber(currentUser).get().getName());
                    switch (choice) {
                        case Const.VIEW_REG_USERS -> GCashShareLoad.displayAllUsers();
                        case Const.VIEW_ALL_TRANSACTION_HISTORY -> GCashShareLoad.displayTransactionHistory();
                        case Const.EXIT -> {
                            System.out.println("Program exiting...");
                            System.out.println("Thanks for using Share-a-Load!");
                            System.out.println("----------------------------------------");
                            inSession = false;
                        }
                        case Const.LOGOUT -> {
                            System.out.println("Successfully logged out...");
                            state = Const.STATE_LANDING_PAGE;
                        }
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        
        // Close the scanner
        scanner.close();
    }

    //----------------------------------------------------------------
    // Helper methods
    //----------------------------------------------------------------

    /**
     * @param transaction List of user transactions
     * @param name Name of the user requesting the display
     */
    private static void displayUserTransaction(List<Transaction> transaction, String name) {
        System.out.println("Displaying transaction for user " + name + "...");
        for(Transaction history : transaction) {
            System.out.println(history);
        }
    }

    /**
     * Displays the landing page of the application
     * @return The desired next action of the user
     */
    private static int displayLandingPage() {
        System.out.println("----------------------------------------");
        System.out.println("Welcome to GCash Share-a-Load!");
        System.out.println("\t1. Register a new user.");
        System.out.println("\t2. Login");
        System.out.println("\t3. Exit");
        int choice = inputChoice();
        System.out.println("----------------------------------------");
        return choice;
    }

    /**
     * @param userName Name of current user
     * @param balance Current balance of user
     * @return The desired next action of the user
     */
    private static int displayUserPage(String userName, double balance) {
        System.out.println("----------------------------------------");
        System.out.println("Welcome, " + userName + "!");
        System.out.println("Balance: " + balance);
        System.out.println("\t1. Share load");
        System.out.println("\t2. View my transaction history");
        System.out.println("\t3. Exit");
        System.out.println("\t4. Logout");
        int choice = inputChoice();
        System.out.println("----------------------------------------");
        return choice;
    }

    /**
     * @param adminName Name of the admin
     * @return The desired next action of the admin
     */
    private static int displayAdminPage(String adminName) {
        System.out.println("----------------------------------------");
        System.out.println("Welcome, " + adminName + "!");
        System.out.println("\t1. View all registered users");
        System.out.println("\t2. View all transaction history");
        System.out.println("\t3. Exit");
        System.out.println("\t4. Logout");
        int choice = inputChoice();
        System.out.println("----------------------------------------");
        return choice;
    }

    /**
     * @return The desired next action of the user
     */
    private static int inputChoice() {
        System.out.print("Please choose an action: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume the invalid input
            System.out.print("Please choose an action: ");
        }
        return scanner.nextInt();
    }
}
