import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private int accountNumber;
    private String holderName;
    private double balance;

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Accessor and modifier functions for data members
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void calculateYearlyInterest() {
        double interest = getBalance() * interestRate / 100;
        setBalance(getBalance() + interest);
        System.out.println("Interest calculated for SavingsAccount with Account Number " + getAccountNumber() +
                " at interest rate " + interestRate + "%: ₹" + interest);
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
}

class Manager {
    private ArrayList<Account> accountList;

    public Manager() {
        accountList = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();

        // Adding SavingsAccount instances
        System.out.println("Enter details for SavingsAccount 1:");
        SavingsAccount savingsAccount1 = createSavingsAccount(scanner);

        System.out.println("Enter details for SavingsAccount 2:");
        SavingsAccount savingsAccount2 = createSavingsAccount(scanner);

        // Adding CurrentAccount instances
        System.out.println("Enter details for CurrentAccount 1:");
        CurrentAccount currentAccount1 = createCurrentAccount(scanner);

        System.out.println("Enter details for CurrentAccount 2:");
        CurrentAccount currentAccount2 = createCurrentAccount(scanner);

        System.out.println("Enter details for CurrentAccount 3:");
        CurrentAccount currentAccount3 = createCurrentAccount(scanner);

        // Adding accounts to Manager
        manager.addAccount(savingsAccount1);
        manager.addAccount(savingsAccount2);
        manager.addAccount(currentAccount1);
        manager.addAccount(currentAccount2);
        manager.addAccount(currentAccount3);

        // Calculate interest for SavingsAccounts
        savingsAccount1.calculateYearlyInterest();
        savingsAccount2.calculateYearlyInterest();

        // Print details of all accounts
        System.out.println("Account details:");
        for (Account account : manager.getAccountList()) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Holder Name: " + account.getHolderName());
            System.out.println("Balance: ₹" + account.getBalance());
            System.out.println();
        }

        // Close the scanner
        scanner.close();
    }

    private static SavingsAccount createSavingsAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter account holder name: ");
        String holderName = scanner.next();

        System.out.print("Enter initial balance (in Rupees): ₹");
        double balance = scanner.nextDouble();

        System.out.print("Enter interest rate: ");
        double interestRate = scanner.nextDouble();

        return new SavingsAccount(accountNumber, holderName, balance, interestRate);
    }

    private static CurrentAccount createCurrentAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter account holder name: ");
        String holderName = scanner.next();

        System.out.print("Enter initial balance (in Rupees): ₹");
        double balance = scanner.nextDouble();

        return new CurrentAccount(accountNumber, holderName, balance);
    }
}