package data_structures.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class Week10_P1_VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String word = sc.next().toLowerCase(Locale.ROOT);
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if ("aeiou".indexOf(ch) >= 0) vowels++;
            else if (ch >= 'a' && ch <= 'z') consonants++;
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
