package polymorphism.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class Week8_P2_CampusParkingChargeCalculator {
    interface ParkingVehicle {
        double charge(int hours);
    }

    static class Bike implements ParkingVehicle {
        public double charge(int hours) { return 10.0 * hours; }
    }

    static class Car implements ParkingVehicle {
        public double charge(int hours) { return hours == 1 ? 30.0 : 30.0 + 20.0 * (hours - 1); }
    }

    static class Truck implements ParkingVehicle {
        public double charge(int hours) { return Math.max(100.0, 50.0 * hours); }
    }

    static ParkingVehicle createVehicle(String type) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "BIKE": return new Bike();
            case "CAR": return new Car();
            case "TRUCK": return new Truck();
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            int hours = sc.nextInt();
            double charge = createVehicle(type).charge(hours);
            System.out.printf(Locale.US, "%s: %.2f%n", type, charge);
            total += charge;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
