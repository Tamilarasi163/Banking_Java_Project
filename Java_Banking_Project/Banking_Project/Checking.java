package Banking_Project;

public class Checking extends Account {
    private int debitCardNumber; // Debit card number
    private int debitCardPin;    // Debit card PIN

    // Constructor to initialize a new checking account
    public Checking(String name, String sSN, double initialDeposit) {
        super(name, sSN, initialDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    // Method to set the interest rate for checking accounts
    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }

    // Method to generate a debit card number and PIN
    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPin = (int) (Math.random() * Math.pow(10, 4));
        System.out.println("CARD: " + debitCardNumber);
        System.out.println("PIN: " + debitCardPin);
    }

    // Method to display checking account information
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("ACCOUNT TYPE: Checking");
        System.out.println("Your Checking Account Features:" +
                "\n Debit Card Number: " + debitCardNumber +
                "\n Debit Card PIN: " + debitCardPin);
    }
}
