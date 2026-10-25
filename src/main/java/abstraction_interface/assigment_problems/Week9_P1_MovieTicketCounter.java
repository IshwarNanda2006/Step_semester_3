package abstraction_interface.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class Week9_P1_MovieTicketCounter {
    abstract static class Ticket {
        private static final double CONVENIENCE_FEE = 20.0;
        abstract double seatPrice();
        final double bookingAmount(int count) { return count * (seatPrice() + CONVENIENCE_FEE); }
    }
    static class Regular extends Ticket { double seatPrice() { return 150.0; } }
    static class Premium extends Ticket { double seatPrice() { return 250.0; } }
    static class Recliner extends Ticket { double seatPrice() { return 400.0; } }

    static Ticket create(String seat) {
        switch (seat.toUpperCase(Locale.ROOT)) {
            case "REGULAR": return new Regular();
            case "PREMIUM": return new Premium();
            case "RECLINER": return new Recliner();
            default: throw new IllegalArgumentException("Unknown seat type: " + seat);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase(Locale.ROOT);
            int count = sc.nextInt();
            double amount = create(seat).bookingAmount(count);
            System.out.printf(Locale.US, "%s: %.2f%n", seat, amount);
            total += amount;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
