package data_structures.class_problems;

import java.util.Scanner;

public class Week10_P6_PrimeNumberChecker {
    static boolean isPrime(long number) {
        if (number < 2) return false;
        for (long divisor = 2; divisor <= number / divisor; divisor++) {
            if (number % divisor == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long number = sc.nextLong();
            System.out.println(number + (isPrime(number) ? " is prime" : " is not prime"));
        }
    }
}
