import java.util.ArrayList;
        import java.util.List;

// BankOperation is an abstract class that defines common banking operations
class Main{
    public static void main(String args[]){
        
    }
}
abstract class BankOperation {
    // Abstract method to perform a transaction
    public abstract boolean performTransaction(Transaction transaction);
}

// Account interface defines the properties and methods for an account
interface Account {
    int getAccountNumber();
    String getAccountType();
    double getBalance();
    boolean deposit(double amount);
    boolean withdraw(double amount);
}

// IndividualAccount class implements the Account interface and represents an individual account
class IndividualAccount implements Account {
    private int accountNumber;
    private String accountType;
    private double balance;

    public IndividualAccount(int accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// JointAccount class implements the Account interface and represents a joint account
class JointAccount implements Account {
    private int accountNumber;
    private String accountType;
    private double balance;
    private List<Customer> customers;

    public JointAccount(int accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.customers = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}

// Customer class represents a bank customer
class Customer {
    private String name;
    private String contactInfo;
    private List<Account> accounts;

    public Customer(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}

// Transaction class represents a bank transaction
class Transaction {
    private Account account;
    private double amount;
    private String transactionType;

    public Transaction(Account account, double amount, String transactionType) {
        this.account = account;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public Account getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }
}

// Bank class represents a bank and provides methods for managing accounts and transactions
class Bank extends BankOperation {
    private List<Customer> customers;
    private List<Account> accounts;
    private List<Transaction> transactions;

    public Bank() {
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Override performTransaction method to perform a transaction
    @Override
    public boolean performTransaction(Transaction transaction) {
        if (transaction.getTransactionType().equals("Deposit")) {
            return transaction.getAccount().deposit(transaction.getAmount());
        } else if (transaction.getTransactionType().equals("Withdrawal")) {
            return transaction.getAccount().withdraw(transaction.getAmount());
        } else {
            return false;
        }
    }

    public boolean transferFunds(Account fromAccount, Account toAccount, double amount) {
        Transaction withdrawalTransaction = new Transaction(fromAccount, amount, "Withdrawal");
        Transaction depositTransaction = new Transaction(toAccount, amount, "Deposit");

        boolean withdrawalSuccess = performTransaction(withdrawalTransaction);
        if (withdrawalSuccess) {
            boolean depositSuccess = performTransaction(depositTransaction);
            if (depositSuccess) {
                addTransaction(withdrawalTransaction);
                addTransaction(depositTransaction);
                return true;
            } else {
                performTransaction(new Transaction(fromAccount, amount, "Deposit"));
                return false;
            }
        } else {
            return false;
        }
    }

    public List<Transaction> getTransactionHistory(Account account) {
        List<Transaction> transactionHistory = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getAccount().getAccountNumber() == account.getAccountNumber()) {
                transactionHistory.add(transaction);
            }
        }
        return transactionHistory;
    }
}

