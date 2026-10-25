package abstraction_interface.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class Week9_P5_PublicTransportFareCalculator {
    interface Transport { double fare(double distance, double factor); }
    static class Bus implements Transport { public double fare(double distance, double factor) { return Math.min(10.0, 2.0 + 0.10 * distance); } }
    static class Train implements Transport { public double fare(double distance, double factor) { return 3.0 + 0.15 * distance; } }
    static class Metro implements Transport { public double fare(double distance, double factor) { return (1.50 + 0.20 * distance) * factor; } }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double distance = sc.nextDouble();
            double factor = type.equals("METRO") ? sc.nextDouble() : 1.0;
            Transport transport;
            switch (type) {
                case "BUS": transport = new Bus(); break;
                case "TRAIN": transport = new Train(); break;
                case "METRO": transport = new Metro(); break;
                default: throw new IllegalArgumentException("Unknown transport type: " + type);
            }
            double fare = transport.fare(distance, factor);
            System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
            total += fare;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
