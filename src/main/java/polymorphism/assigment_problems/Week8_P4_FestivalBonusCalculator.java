package polymorphism.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class Week8_P4_FestivalBonusCalculator {
    interface BonusRule {
        double bonus(double salary);
    }

    static class FullTime implements BonusRule {
        public double bonus(double salary) { return salary * 0.10; }
    }

    static class PartTime implements BonusRule {
        public double bonus(double salary) { return salary * 0.05; }
    }

    static class Intern implements BonusRule {
        public double bonus(double salary) { return 2000.0; }
    }

    static BonusRule createRule(String type) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "FULLTIME": return new FullTime();
            case "PARTTIME": return new PartTime();
            case "INTERN": return new Intern();
            default: throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            String name = sc.next();
            double salary = sc.nextDouble();
            double bonus = createRule(type).bonus(salary);
            System.out.printf(Locale.US, "%s: %.2f%n", name, bonus);
            total += bonus;
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
    }
}
