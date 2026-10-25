package abstraction_interface.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class Week9_P5_HomeApplianceEnergyReport {
    interface SaverMode {
        default double reduceUnits(double normalUnits) { return normalUnits * 0.75; }
    }

    abstract static class Appliance {
        final double hours;
        Appliance(double hours) { this.hours = hours; }
        abstract double powerWatts();
        final double units() { return powerWatts() * hours / 1000.0; }
        final double cost(double units) { return units * 8.0; }
    }
    static class Fridge extends Appliance { Fridge(double h) { super(h); } double powerWatts() { return 150.0; } }
    static class Ac extends Appliance implements SaverMode { Ac(double h) { super(h); } double powerWatts() { return 1500.0; } }
    static class Tv extends Appliance { Tv(double h) { super(h); } double powerWatts() { return 100.0; } }
    static class Washer extends Appliance implements SaverMode { Washer(double h) { super(h); } double powerWatts() { return 500.0; } }

    static Appliance create(String type, double hours) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "FRIDGE": return new Fridge(hours);
            case "AC": return new Ac(hours);
            case "TV": return new Tv(hours);
            case "WASHER": return new Washer(hours);
            default: throw new IllegalArgumentException("Unknown appliance: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext("SAVER");
            if (saver) sc.next();
            Appliance appliance = create(type, hours);
            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }
            double units = appliance.units();
            if (saver) units = ((SaverMode) appliance).reduceUnits(units);
            double cost = appliance.cost(units);
            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", type, units, cost);
            totalCost += cost;
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }
}
