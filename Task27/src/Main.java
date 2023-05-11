import java.util.*;
import java.time.LocalDateTime;
public class Main {
    public static void main(String[] args) {

    }
}



abstract class Account {
    private double balance;
    private String accountNumber;
    private String accountType;

    public Account(double balance, String accountNumber, String accountType) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public abstract double getInterestRate();
}

class CheckingAccount extends Account {
    private final double INTEREST_RATE = 0.01;

    public CheckingAccount(double balance, String accountNumber) {
        super(balance, accountNumber, "Checking");
    }

    public double getInterestRate() {
        return INTEREST_RATE;
    }
}

class SavingsAccount extends Account {
    private final double INTEREST_RATE = 0.03;

    public SavingsAccount(double balance, String accountNumber) {
        super(balance, accountNumber, "Savings");
    }

    public double getInterestRate() {
        return INTEREST_RATE;
    }
}

class Customer {
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Account> accounts;

    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account getAccountByNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public boolean transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = getAccountByNumber(fromAccountNumber);
        Account toAccount = getAccountByNumber(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            return false;
        }

        if (fromAccount.getBalance() < amount) {
            return false;
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        return true;
    }
}

enum TransactionType {
    DEPOSIT,
    WITHDRAWAL
}

abstract class Transaction {
    private Account account;
    private TransactionType type;
    private double amount;
    private LocalDateTime date;

    public Transaction(Account account, TransactionType type, double amount) {
        this.account = account;
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public Account getAccount() {
        return account;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public abstract void execute();
}

class DepositTransaction extends Transaction {
    public DepositTransaction(Account account, double amount) {
        super(account, TransactionType.DEPOSIT, amount);
    }

    public void execute() {
        getAccount().setBalance(getAccount().getBalance() + getAmount());
    }
}


