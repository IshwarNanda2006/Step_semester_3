package data_structures.assigment_problems;

import java.util.Arrays;

public class Week10_P8_DutyRosterRotation {
    static String[] rotateRoster(String[] names, long k) {
        if (names.length == 0) return new String[0];
        int shift = (int) (k % names.length);
        String[] rotated = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            rotated[(i + shift) % names.length] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names, 2)));
        System.out.println(Arrays.toString(rotateRoster(names, 7)));
    }
}
