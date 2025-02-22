////////////////////////////////////////////////////////////////////
/// 1.Banking Application:Account.java
/// 2.Used Entities: variales,paramaterized constructor,
/// getter and setter methods,user-defined methods,exception handling
/// 3.Functionality:Represents a bank account
/// 4..Date: 22-02-2025
////////////////////////////////////////////////////////////////////
public class Account {
    private String accountNumber;
    private String customerName;
    private double balance;
    private String accountType;

    public Account(String accountNumber, String customerName, String accountType) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = 0.0;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getCustomerName() { return customerName; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
    }
}