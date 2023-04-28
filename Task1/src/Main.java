import java.util.ArrayList;
import java.util.List;

// Abstract class for account operations
abstract class AccountOperations {
    // Abstract method to perform a transaction
    public abstract void doTransaction(Transaction transaction);
}

// Class for Customers
class Customer {
    private String name;
    private String address;
    private String contactInfo;

    // Constructor
    public Customer(String name, String address, String contactInfo) {
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactInfo() {
        return contactInfo;
    }
}

// Class for Transactions
class Transaction {
    private Account account;
    private String transactionType;
    private double amount;

    // Constructor
    public Transaction(Account account, String transactionType, double amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    // Getters
    public Account getAccount() {
        return account;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }
}

// Abstract class for Accounts
abstract class Account {
    private String accountType;
    private double balance;
    private double interestRate;
    private Customer customer;

    // Constructor
    public Account(String accountType, double balance, double interestRate, Customer customer) {
        this.accountType = accountType;
        this.balance = balance;
        this.interestRate = interestRate;
        this.customer = customer;
    }

    // Getters and Setters
    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public Customer getCustomer() {
        return customer;
    }

    // Abstract method to calculate interest
    public abstract double calculateInterest();

    // Abstract method to perform a transaction
    public abstract void doTransaction(Transaction transaction);
}

// SavingsAccount class
class SavingsAccount extends Account {
    private static final String ACCOUNT_TYPE = "Savings";

    // Constructor
    public SavingsAccount(double balance, double interestRate, Customer customer) {
        super(ACCOUNT_TYPE, balance, interestRate, customer);
    }

    // Override abstract methods
    @Override
    public double calculateInterest() {
        return getBalance() * getInterestRate();
    }

    @Override
    public void doTransaction(Transaction transaction) {
        Account account = transaction.getAccount();
        String transactionType = transaction.getTransactionType();
        double amount = transaction.getAmount();

        if (transactionType.equals("Deposit")) {
            account.setBalance(account.getBalance() + amount);
        } else if (transactionType.equals("Withdraw")) {
            if (amount > account.getBalance()) {
                System.out.println("Insufficient balance.");
            } else {
                account.setBalance(account.getBalance() - amount);
            }
        }
    }
}

// CheckingAccount class
class CheckingAccount extends Account {
    private static final String ACCOUNT_TYPE = "Checking";

    // Constructor
    public CheckingAccount(double balance, double interestRate, Customer customer) {
        super(ACCOUNT_TYPE, balance, interestRate, customer);
    }

    // Override abstract methods
    @Override
}