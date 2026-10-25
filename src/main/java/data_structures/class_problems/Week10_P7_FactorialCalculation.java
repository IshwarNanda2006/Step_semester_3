package data_structures.class_problems;

import java.math.BigInteger;
import java.util.Scanner;

public class Week10_P7_FactorialCalculation {
    static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n < 0) {
                System.out.println("Invalid input");
            } else {
                System.out.println(factorial(n));
            }
        }
    }
}
