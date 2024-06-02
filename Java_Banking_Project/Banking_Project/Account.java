package Banking_Project;

public abstract class Account implements Rate {
    private String name;  // Account holder's name
    private String sSN;   // Social Security Number of the account holder
    private double balance; // Current balance of the account
    private static int index = 10000; // A static variable to generate unique account numbers
    protected String accountNumber; // Account number
    protected double rate; // Interest rate for the account

    // Constructor to initialize a new account
    public Account(String name, String sSN, double initialDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initialDeposit;
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    // Abstract method to set the interest rate, implemented in subclasses
    public abstract void setRate();

    // Generates a unique account number
    private String setAccountNumber() {
        int uniqueID = index;
        String lastTwoIndex = sSN.substring(sSN.length() - 2);
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoIndex + uniqueID + randomNumber;
    }

    // Method to calculate and apply accrued interest to the balance
    public void compound() {
        double accruedInterest = balance * (rate / 100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    // Method to deposit a specified amount
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    // Method to withdraw a specified amount
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    // Method to transfer a specified amount to another account
    public void transfer(String toWhere, double amount) {
        balance -= amount;
        System.out.println("Transferring $" + amount + " to " + toWhere);
        printBalance();
    }

    // Method to print the current balance
    public void printBalance() {
        System.out.println("Your balance is now: $" + balance);
    }

    // Method to display account information
    public void showInfo() {
        System.out.println(
            "NAME: " + name +
            "\nACCOUNT NUMBER: " + accountNumber +
            "\nBALANCE: " + balance
        );
    }

    // Method to convert account details to CSV format
    public String toCSV() {
        return name + "," + sSN + "," + (this instanceof Savings ? "Savings" : "Checking") + "," + balance;
    }
}
