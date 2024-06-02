package Banking_Project;

public class Savings extends Account {
    private int safetyDepositBoxID;   // Safety deposit box ID
    private int safetyDepositBoxKey;  // Safety deposit box key

    // Constructor to initialize a new savings account
    public Savings(String name, String sSN, double initialDeposit) {
        super(name, sSN, initialDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    // Method to set the interest rate for savings accounts
    @Override
    public void setRate() {
        rate = getBaseRate() - 1.25;
    }

    // Method to generate a safety deposit box ID and key
    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * 10000);
        safetyDepositBoxKey = (int) (Math.random() * 1000);
    }

    // Method to display savings account information
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("ACCOUNT TYPE: Savings");
        System.out.println("Your Savings Account Features:" +
                "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                "\n Safety Deposit Box Key: " + safetyDepositBoxKey);
    }
}
