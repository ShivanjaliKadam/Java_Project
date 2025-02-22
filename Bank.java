////////////////////////////////////////////////////////////////////
/// 1.Banking Application:Bank.java
/// 2.Used Entities:required packages,instance variales,constructor,
/// user-defined methods,exception handling
/// 3.Functionality:Manages multiple bank accounts and provides 
/// functionalities like account creation,deposit,withdrawal,transfer
/// and balance retrieval.
/// 4.Date: 22-02-2025
////////////////////////////////////////////////////////////////////
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;
    private static int accountCounter = 1000;

    public Bank() {
        accounts = new HashMap<>();
    }

    public String createAccount(String customerName, String accountType) {
        String accountNumber = generateAccountNumber();
        Account account = new Account(accountNumber, customerName, accountType);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    private String generateAccountNumber() {
        return "ACC" + (++accountCounter);
    }

    public void deposit(String accountNumber, double amount) 
            throws AccountNotFoundException, InvalidAmountException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) 
            throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) 
            throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);
        
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public double getBalance(String accountNumber) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        return account.getBalance();
    }

    private Account findAccount(String accountNumber) throws AccountNotFoundException {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found: " + accountNumber);
        }
        return account;
    }
}