package polymorphism.assigment_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Week8_P5_StreamingPlanRenewalReminder {
    abstract static class Plan {
        final String name;
        final LocalDate startDate;
        Plan(String name, LocalDate startDate) { this.name = name; this.startDate = startDate; }
        abstract int validityDays();
        LocalDate renewalDate() { return startDate.plusDays(validityDays()); }
    }

    static class Basic extends Plan {
        Basic(String name, LocalDate date) { super(name, date); }
        int validityDays() { return 30; }
    }

    static class Standard extends Plan {
        Standard(String name, LocalDate date) { super(name, date); }
        int validityDays() { return 90; }
    }

    static class Premium extends Plan {
        Premium(String name, LocalDate date) { super(name, date); }
        int validityDays() { return 365; }
    }

    static Plan createPlan(String type, String name, LocalDate date) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "BASIC": return new Basic(name, date);
            case "STANDARD": return new Standard(name, date);
            case "PREMIUM": return new Premium(name, date);
            default: throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next(), fmt);
            System.out.println(name + ": " + createPlan(type, name, start).renewalDate().format(fmt));
        }
    }
}
