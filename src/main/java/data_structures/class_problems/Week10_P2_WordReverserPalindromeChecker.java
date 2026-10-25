package data_structures.class_problems;

import java.util.Scanner;

public class Week10_P2_WordReverserPalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String word = sc.next();
            String reversed = new StringBuilder(word).reverse().toString();
            System.out.println(reversed + " - " +
                (word.equals(reversed) ? "palindrome" : "not a palindrome"));
        }
    }
}
