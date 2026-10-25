package abstraction_interface.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class Week9_P1_PaymentSystemFeeCalculation {
    interface PaymentMethod { double adjustedAmount(double amount); }
    static class Card implements PaymentMethod { public double adjustedAmount(double amount) { return amount * 1.02; } }
    static class Wallet implements PaymentMethod { public double adjustedAmount(double amount) { return amount * 1.01; } }
    static class BankTransfer implements PaymentMethod { public double adjustedAmount(double amount) { return amount; } }

    static PaymentMethod create(String type) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "CARD": return new Card();
            case "WALLET": return new Wallet();
            case "BANKTRANSFER": return new BankTransfer();
            default: throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double amount = sc.nextDouble();
            double adjusted = create(type).adjustedAmount(amount);
            System.out.printf(Locale.US, "%s: %.2f%n", type, adjusted);
            total += adjusted;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
