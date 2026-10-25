package data_structures.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week10_P4_InPlaceArrayReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\A");
        if (!sc.hasNext()) return;
        Matcher matcher = Pattern.compile("-?\\d+").matcher(sc.next());
        List<Integer> values = new ArrayList<>();
        while (matcher.find()) values.add(Integer.parseInt(matcher.group()));
        int[] numbers = new int[values.size()];
        for (int i = 0; i < values.size(); i++) numbers[i] = values.get(i);
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }
        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(numbers[i]);
        }
        System.out.println("]");
    }
}
