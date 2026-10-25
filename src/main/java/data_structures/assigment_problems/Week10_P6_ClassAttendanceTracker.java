package data_structures.assigment_problems;

public class Week10_P6_ClassAttendanceTracker {
    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else {
                currentStreak = 0;
            }
        }
        return new int[]{present, longestStreak};
    }

    public static void main(String[] args) {
        int[] result1 = attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1});
        int[] result2 = attendanceSummary(new int[]{0, 0, 0});
        System.out.println("Present: " + result1[0] + ", Longest streak: " + result1[1]);
        System.out.println("Present: " + result2[0] + ", Longest streak: " + result2[1]);
    }
}
