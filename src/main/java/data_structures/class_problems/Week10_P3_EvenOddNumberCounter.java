package data_structures.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week10_P3_EvenOddNumberCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\A");
        if (!sc.hasNext()) return;
        String input = sc.next();
        Matcher matcher = Pattern.compile("-?\\d+").matcher(input);
        List<Integer> numbers = new ArrayList<>();
        while (matcher.find()) numbers.add(Integer.parseInt(matcher.group()));
        int even = 0;
        int odd = 0;
        for (int number : numbers) {
            if (number % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
