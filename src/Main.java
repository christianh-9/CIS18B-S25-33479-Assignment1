import java.util.Scanner;

class BankAccount {
    // Private member variables
    private String accountHolderName;
    private double accountNumber;
    private double balance;

    // Class constructor to set values
    BankAccount(String a, double b, double c) {
        this.accountHolderName = a;
        this.accountNumber = b;
        this.balance = c;
    }

    void deposit(double amount) {
        // Input validation for negative deposit amounts
        if (amount < 0) {
            System.out.println("Enter a positive amount");
        }
        else {
            balance += amount;
            System.out.println("Successfully deposited, your balance is now $" + balance);
        }
    }

    void withdraw(double amount) {
        // Input validation for negative or insufficient withdrawal amounts
        if (balance < amount) {
            System.out.println("Insufficient funds");
        }
        else if (amount < 0) {
            System.out.println("Enter a positive amount");
        }
        else {
            balance -= amount;
            System.out.println("Successfully withdrawn, your balance is now $" + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // User input
        boolean createdAccount = false; // To check if account is created or not
        BankAccount newAccount = null; // To allow the whole class to access class members
        int choice; // For switch statement

        // Loop to ensure user creates account first
        do {
            System.out.println("\nWelcome to Christian's Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit\n");
            System.out.print("Enter a valid choice: ");

            // try-catch block for non-numeric values
            try {
                choice = scanner.nextInt(); // read choice
                scanner.nextLine();

                if (choice == 1) {

                    System.out.println("Enter Account Holder Name: ");
                    String accountHolderName = scanner.nextLine();

                    double accountNumber = 0, initialDeposit = 0;
                    boolean validInput = false;

                    // will loop until input is validated
                    while (!validInput) {
                        // try-catch block for account # and deposit
                        try {
                            System.out.println("Enter Account Number: ");
                            accountNumber = scanner.nextDouble();

                            System.out.println("Enter initial deposit: ");
                            initialDeposit = scanner.nextDouble();
                            scanner.nextLine();

                            validInput = true;
                        } catch (Exception e) {
                            System.out.println("Invalid input, enter a valid number");
                            scanner.nextLine();
                        }
                    }
                    newAccount = new BankAccount(accountHolderName, accountNumber, initialDeposit); // Create new object
                    createdAccount = true; // move onto next loop
                    System.out.println("Your account under " + accountHolderName + " has been created");

                } else if (choice == 5) {
                    System.out.println("Thank you for banking with us!");
                    return;
                }
                else if (choice > 1 && choice < 5) {
                    System.out.println("You have not created an account yet");
                }
                else {
                    System.out.println("Invalid number, enter a number 1-5");
                }

            } catch (Exception e) {
                System.out.println("Invalid input, enter an integer");
                scanner.nextLine();
                }
        } while (!createdAccount); // Will loop until is created

        // Second loop to run until user exits
        while (true) {
            System.out.println("\n1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter a valid choice: \n");

            // try-catch block for non-numeric values
            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: {
                        // try-catch for deposit
                        try {
                            System.out.println("Enter how much you would like to deposit: ");
                            double depositMoney = scanner.nextDouble();
                            scanner.nextLine();
                            newAccount.deposit(depositMoney);

                        } catch (Exception e) {
                            System.out.println("Invalid input, enter a valid amount");
                            scanner.nextLine();
                        }
                        break;
                    }
                    case 2: {
                        // try-catch for withdraw
                        try {
                            System.out.println("Enter how much you would like to withdraw: ");
                            double withdrawMoney = scanner.nextDouble();
                            scanner.nextLine();
                            newAccount.withdraw(withdrawMoney);

                        } catch (Exception e) {
                            System.out.println("Invalid input, enter a valid amount");
                            scanner.nextLine();
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Current balance: $" + newAccount.getBalance());
                        break;
                    }
                    case 4: {
                        System.out.println("Thank you for banking with us!");
                        return;
                    }
                    default: {
                        System.out.println("Invalid choice, enter a number 1-4");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input, enter an integer");
                scanner.nextLine();
            }
        }
    }
}