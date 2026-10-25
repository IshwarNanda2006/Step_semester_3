package data_structures.class_problems;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week10_P10_StudentResultCardGenerator {
    static String grade(double average) {
        if (average >= 90) return "A";
        if (average >= 75) return "B";
        if (average >= 60) return "C";
        if (average >= 40) return "D";
        return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern numberPattern = Pattern.compile("\\d+(?:\\.\\d+)?");
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            Matcher matcher = numberPattern.matcher(line);
            double total = 0;
            int count = 0;
            while (matcher.find() && count < 3) {
                total += Double.parseDouble(matcher.group());
                count++;
            }
            if (count != 3) continue;
            String name = line.split("\\s+")[0].replaceAll("[^A-Za-z]+$", "");
            double average = total / 3.0;
            System.out.printf(Locale.US, "%s: Average %.1f, Grade %s%n",
                name.toUpperCase(Locale.ROOT), average, grade(average));
        }
    }

    private static int matcherStart(String line, Pattern pattern) {
        Matcher matcher = pattern.matcher(line);
        return matcher.find() ? matcher.start() : line.length();
    }
}
