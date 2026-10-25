package abstraction_interface.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class Week9_P4_CityCabFareMeter {
    interface NightService {
        default double applyNightSurcharge(double fare) { return fare * 1.20; }
    }

    abstract static class Cab {
        final double distance;
        Cab(double distance) { this.distance = distance; }
        abstract double rate();
        final double dayFare() { return Math.max(100.0, distance * rate()); }
    }
    static class Mini extends Cab { Mini(double d) { super(d); } double rate() { return 10.0; } }
    static class Sedan extends Cab implements NightService { Sedan(double d) { super(d); } double rate() { return 14.0; } }
    static class Suv extends Cab implements NightService { Suv(double d) { super(d); } double rate() { return 18.0; } }

    static Cab create(String type, double distance) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "MINI": return new Mini(distance);
            case "SEDAN": return new Sedan(distance);
            case "SUV": return new Suv(distance);
            default: throw new IllegalArgumentException("Unknown cab type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase(Locale.ROOT);
            Cab cab = create(type, km);
            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }
            double fare = cab.dayFare();
            if (time.equals("NIGHT")) fare = ((NightService) cab).applyNightSurcharge(fare);
            System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
            total += fare;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
