package data_structures.class_problems;

import java.util.Scanner;

public class Week10_P5_DigitSumAndNumberReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long number = sc.nextLong();
            long value = number;
            long sum = 0;
            long reversed = 0;
            while (value > 0) {
                long digit = value % 10;
                sum += digit;
                reversed = reversed * 10 + digit;
                value /= 10;
            }
            System.out.println("Sum of digits: " + sum);
            System.out.println("Reverse: " + reversed);
        }
    }
}
