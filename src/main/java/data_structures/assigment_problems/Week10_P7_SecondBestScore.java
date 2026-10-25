package data_structures.assigment_problems;

import java.util.Arrays;

public class Week10_P7_SecondBestScore {
    static int secondHighest(int[] scores) {
        int highest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest(new int[]{45, 78, 92, 78, 60}));
        System.out.println(secondHighest(new int[]{50, 50, 50}));
    }
}
