import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private String name;
    private double amount;

    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Expense Name: " + name + ", Amount: $" + amount;
    }
}

public class ExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Remove Expense");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    removeExpense();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    private static void addExpense() {
        System.out.print("Enter the expense name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the amount: $");
        double amount = scanner.nextDouble();
        expenses.add(new Expense(name, amount));
        System.out.println("Expense added successfully.");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("\n--- All Expenses ---");
            double total = 0;
            for (Expense expense : expenses) {
                System.out.println(expense);
                total += expense.getAmount();
            }
            System.out.println("Total Expenses: $" + total);
        }
    }

    private static void removeExpense() {
        System.out.print("Enter the name of the expense to remove: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Expense expense : expenses) {
            if (expense.getName().equalsIgnoreCase(name)) {
                expenses.remove(expense);
                System.out.println("Expense removed successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Expense not found.");
        }
    }
}
