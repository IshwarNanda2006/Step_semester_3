package abstraction_interface.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class Week9_P3_CollegeFeeCounter {
    interface BusUser { }

    abstract static class StudentFee {
        final String name;
        StudentFee(String name) { this.name = name; }
        abstract double tuition();
        double extraFees() { return 0.0; }
        final double totalFee() { return tuition() + extraFees() + (this instanceof BusUser ? 12000.0 : 0.0); }
    }
    static class DayScholar extends StudentFee implements BusUser {
        DayScholar(String name) { super(name); }
        double tuition() { return 40000.0; }
    }
    static class Hosteller extends StudentFee {
        Hosteller(String name) { super(name); }
        double tuition() { return 40000.0; }
        double extraFees() { return 60000.0; }
    }
    static class Scholar extends StudentFee implements BusUser {
        Scholar(String name) { super(name); }
        double tuition() { return 20000.0; }
    }

    static StudentFee create(String type, String name) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "DAY_SCHOLAR": return new DayScholar(name);
            case "HOSTELLER": return new Hosteller(name);
            case "SCHOLAR": return new Scholar(name);
            default: throw new IllegalArgumentException("Unknown student type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double fee = create(type, name).totalFee();
            System.out.printf(Locale.US, "%s: %.2f%n", name, fee);
            total += fee;
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
    }
}
