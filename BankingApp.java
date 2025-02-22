////////////////////////////////////////////////////////////////////
/// 1.Banking Application:BankingApp.java
/// 2.Used Entities: variales,constructor,
/// getter and setter methods,user-defined methods,exception handling
/// 3.Functionality:Account creation,Deposits and withdrawals,Transfers 
/// between accounts,Balance checking,Exception handling
/// 4..Date: 22-02-2025
////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class BankingApp {
    private Bank bank;
    private Scanner scanner;

    public BankingApp() {
        bank = new Bank();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        transfer();
                        break;
                    case 5:
                        checkBalance();
                        break;
                    case 6:
                        System.out.println("Thank you for using our banking system!😊");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n=== Banking System Menu ===");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Check Balance");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void createAccount() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account type (Savings/Current): ");
        String type = scanner.nextLine();

        String accountNumber = bank.createAccount(name, type);
        System.out.println("Account created successfully! Account number: " + accountNumber);
    }

    private void deposit() throws AccountNotFoundException, InvalidAmountException {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        bank.deposit(accountNumber, amount);
        System.out.println("Deposit successful! New balance: " + bank.getBalance(accountNumber));
    }

    private void withdraw() throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        bank.withdraw(accountNumber, amount);
        System.out.println("Withdrawal successful! New balance💵: " + bank.getBalance(accountNumber));
    }

    private void transfer() throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        System.out.print("Enter source account number: ");
        String fromAccount = scanner.nextLine();
        System.out.print("Enter destination account number: ");
        String toAccount = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        bank.transfer(fromAccount, toAccount, amount);
        System.out.println("Transfer successful!");
        System.out.println("Source account balance: " + bank.getBalance(fromAccount));
        System.out.println("Destination account balance: " + bank.getBalance(toAccount));
    }

    private void checkBalance() throws AccountNotFoundException {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Current balance: " + bank.getBalance(accountNumber));
    }

    public static void main(String[] args) {
        BankingApp app = new BankingApp();
        app.start();
    }
}