package data_structures.class_problems;

import java.util.Scanner;

public class Week10_P9_LeapYearDetector {
    static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int year = sc.nextInt();
            System.out.println(isLeapYear(year) ? "Leap year" : "Not a leap year");
        }
    }
}
