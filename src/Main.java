import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        account currentAccount = null; 
        ArrayList<transaction> transactions = new ArrayList<>(); 

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Enter account details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show current balance");
            System.out.println("5. Cancel last transaction");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter owner name: ");
                    String ownerName = scanner.nextLine();

                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();

                    currentAccount = new account(accountNumber, ownerName, initialBalance);
                    System.out.println("Account details saved.");
                    break;

                case 2:
                    if (currentAccount != null) {
                        System.out.print("Enter the deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        deposit depositTransaction = new deposit(transactions.size() + 1, depositAmount);
                        double newBalance = depositTransaction.execute(currentAccount);
                        transactions.add(depositTransaction);
                        System.out.println("New balance after deposit: " + newBalance);
                    } else {
                        System.out.println("Please enter account details first (Option 1).");
                    }
                    break;

                case 3:
                    if (currentAccount != null) {
                        System.out.print("Enter the withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        withdraw withdrawTransaction = new withdraw(transactions.size() + 1, withdrawalAmount);
                        double newBalance = withdrawTransaction.execute(currentAccount);
                        transactions.add(withdrawTransaction);
                        System.out.println("New balance after withdrawal: " + newBalance);
                    } else {
                        System.out.println("Please enter account details first (Option 1).");
                    }
                    break;

                case 4:
                    if (currentAccount != null) {
                        System.out.print("Enter currency type (U for USD, E for Euro): ");
                        String currencyType = scanner.nextLine().toUpperCase();
                        balanceinquiry balanceInquiry = new balanceinquiry(transactions.size() + 1, currencyType);
                        double currentBalance = balanceInquiry.execute(currentAccount);
                        System.out.println("Current balance: " + currentBalance + " " + currencyType);
                    } else {
                        System.out.println("Please enter account details first (Option 1).");
                    }
                    break;

                case 5:
                    if (!transactions.isEmpty()) {
                        transaction lastTransaction = transactions.remove(transactions.size() - 1);
                        double newBalance = lastTransaction.cancelTransaction(currentAccount);
                        System.out.println("Last transaction canceled. New balance: " + newBalance);
                    } else {
                        System.out.println("No transactions to cancel.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
