package polymorphism.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class Week8_P1_CanteenBillingCounter {
    interface Customer {
        double finalAmount(double amount);
    }

    static class Student implements Customer {
        public double finalAmount(double amount) { return amount * 0.90; }
    }

    static class Staff implements Customer {
        public double finalAmount(double amount) { return amount * 0.95; }
    }

    static class Guest implements Customer {
        public double finalAmount(double amount) { return amount + 10; }
    }

    static Customer createCustomer(String type) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "STUDENT": return new Student();
            case "STAFF": return new Staff();
            case "GUEST": return new Guest();
            default: throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double amount = sc.nextDouble();
            double finalAmount = createCustomer(type).finalAmount(amount);
            System.out.printf(Locale.US, "%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
