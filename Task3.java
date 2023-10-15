import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false; 
        }
    }
}

class ATM {
    private BankAccount userAccount;
    private Scanner sc;

    public ATM(BankAccount account) {
        userAccount = account;
        sc = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("THANK YOU FOR VIGITING US !");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void checkBalance() {
        double balance = userAccount.getBalance();
        System.out.println("Your balance: ₹" + balance);
    }

    public void deposit() {
        System.out.print("Enter the deposit amount: ₹");
        double amount = sc.nextDouble();
        userAccount.deposit(amount);
        System.out.println("Deposit successful.");
    }

    public void withdraw() {
        System.out.print("Enter the withdrawal amount: ₹");
        double amount = sc.nextDouble();

        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); 
        ATM atm = new ATM(account);
        atm.run();
    }
}
