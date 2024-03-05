import java.util.Scanner;

// User class to represent each user of the ATM
class User {
    private String userID;
    private String userPIN;
    private double accountBalance;

    // Constructor
    public User(String userID, String userPIN, double accountBalance) {
        this.userID = userID;
        this.userPIN = userPIN;
        this.accountBalance = accountBalance;
    }

    // Getters and setters
    public String getUserID() {
        return userID;
    }

    public String getUserPIN() {
        return userPIN;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}

// ATM class encapsulating ATM functionalities
class ATM {
    private User currentUser;

    // Constructor
    public ATM(User currentUser) {
        this.currentUser = currentUser;
    }

    // Method to check account balance
    public double checkBalance() {
        return currentUser.getAccountBalance();
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > currentUser.getAccountBalance()) {
            System.out.println("Insufficient funds.");
        } else {
            currentUser.setAccountBalance(currentUser.getAccountBalance() - amount);
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("Remaining balance: " + currentUser.getAccountBalance());
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        currentUser.setAccountBalance(currentUser.getAccountBalance() + amount);
        System.out.println("Amount deposited: " + amount);
        System.out.println("New balance: " + currentUser.getAccountBalance());
    }
}

// Main class for ATM interface
public class ATMInterface {
    public static void main(String[] args) {
        // Sample user creation
        User user = new User("123456", "7890", 1000.00);
        ATM atm = new ATM(user);
        Scanner scanner = new Scanner(System.in);

        // User authentication
        System.out.println("Welcome to the ATM. Please enter your user ID:");
        String userID = scanner.nextLine();
        System.out.println("Please enter your PIN:");
        String userPIN = scanner.nextLine();

        if (userID.equals(user.getUserID()) && userPIN.equals(user.getUserPIN())) {
            System.out.println("Authentication successful.");
            // ATM functionalities
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("Please enter your choice:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Your balance is: " + atm.checkBalance());
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Authentication failed. Invalid user ID or PIN.");
        }

        scanner.close();
    }
}
