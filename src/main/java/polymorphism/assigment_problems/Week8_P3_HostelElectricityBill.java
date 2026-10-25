package polymorphism.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class Week8_P3_HostelElectricityBill {
    interface RoomBill {
        double calculateBill(int units);
    }

    static class SingleRoom implements RoomBill {
        public double calculateBill(int units) { return units * 8.0; }
    }

    static class SharedRoom implements RoomBill {
        private final int occupants;
        SharedRoom(int occupants) { this.occupants = occupants; }
        public double calculateBill(int units) { return units * 6.0 / occupants; }
    }

    static class AcRoom implements RoomBill {
        public double calculateBill(int units) { return units * 10.0 + 200.0; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            int units = sc.nextInt();
            RoomBill room;
            switch (type) {
                case "SINGLE": room = new SingleRoom(); break;
                case "SHARED": room = new SharedRoom(sc.nextInt()); break;
                case "AC": room = new AcRoom(); break;
                default: throw new IllegalArgumentException("Unknown room type: " + type);
            }
            double bill = room.calculateBill(units);
            System.out.printf(Locale.US, "%s: %.2f%n", type, bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
