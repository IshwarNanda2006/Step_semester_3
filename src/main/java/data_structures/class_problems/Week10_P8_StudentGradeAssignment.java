package data_structures.class_problems;

import java.util.Scanner;

public class Week10_P8_StudentGradeAssignment {
    static String grade(int marks) {
        if (marks >= 90) return "A";
        if (marks >= 75) return "B";
        if (marks >= 60) return "C";
        if (marks >= 40) return "D";
        return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) System.out.println("Grade " + grade(sc.nextInt()));
    }
}
