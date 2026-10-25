package abstraction_interface.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class Week9_P2_ParcelShippingDesk {
    interface Insurable { double insuranceAmount(); }

    abstract static class Parcel {
        final double weight, declaredValue;
        Parcel(double weight, double declaredValue) { this.weight = weight; this.declaredValue = declaredValue; }
        abstract double shippingCharge();
        final double insuranceAmountForReport() {
            return this instanceof Insurable ? ((Insurable) this).insuranceAmount() : 0.0;
        }
    }
    static class Standard extends Parcel {
        Standard(double weight, double value) { super(weight, value); }
        double shippingCharge() { return 40 + 10 * weight; }
    }
    static class Express extends Parcel implements Insurable {
        Express(double weight, double value) { super(weight, value); }
        double shippingCharge() { return 80 + 15 * weight; }
        public double insuranceAmount() { return declaredValue * 0.02; }
    }
    static class Fragile extends Parcel implements Insurable {
        Fragile(double weight, double value) { super(weight, value); }
        double shippingCharge() { return 40 + 10 * weight + 50; }
        public double insuranceAmount() { return declaredValue * 0.02; }
    }

    static Parcel create(String type, double weight, double value) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "STANDARD": return new Standard(weight, value);
            case "EXPRESS": return new Express(weight, value);
            case "FRAGILE": return new Fragile(weight, value);
            default: throw new IllegalArgumentException("Unknown parcel type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel parcel = create(type, weight, value);
            double charge = parcel.shippingCharge();
            double insurance = parcel.insuranceAmountForReport();
            double total = charge + insurance;
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }
}
