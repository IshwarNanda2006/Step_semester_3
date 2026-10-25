package abstraction_interface.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class Week9_P3_DeliveryFeeCalculator {
    interface Delivery { double fee(); }
    static class Standard implements Delivery {
        final double weight, distance;
        Standard(double weight, double distance) { this.weight = weight; this.distance = distance; }
        public double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
    }
    static class Express implements Delivery {
        final double weight, distance;
        Express(double weight, double distance) { this.weight = weight; this.distance = distance; }
        public double fee() { return 15 + 1.00 * weight + 0.20 * distance; }
    }
    static class International implements Delivery {
        final double weight, distance, customs;
        International(double weight, double distance, double customs) { this.weight = weight; this.distance = distance; this.customs = customs; }
        public double fee() { return 25 + 2.00 * weight + 0.50 * distance + customs; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            Delivery delivery;
            switch (type) {
                case "STANDARD": delivery = new Standard(weight, distance); break;
                case "EXPRESS": delivery = new Express(weight, distance); break;
                case "INTERNATIONAL": delivery = new International(weight, distance, sc.nextDouble()); break;
                default: throw new IllegalArgumentException("Unknown delivery type: " + type);
            }
            double fee = delivery.fee();
            System.out.printf(Locale.US, "%s: %.2f%n", type, fee);
            total += fee;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
