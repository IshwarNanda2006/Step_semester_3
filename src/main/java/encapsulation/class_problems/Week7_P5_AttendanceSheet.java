package encapsulation.class_problems;

public class Week7_P5_AttendanceSheet {

    static class AttendanceSheet {
        private final String[] presentStudents;
        private int count;

        AttendanceSheet(int maximumStudents) {
            presentStudents = new String[maximumStudents];
            count = 0;
        }

        void markPresent(String name) {
            if (isPresent(name)) {
                return;
            }

            if (count < presentStudents.length) {
                presentStudents[count] = name;
                count++;
            }
        }

        int getPresentCount() {
            return count;
        }

        boolean isPresent(String name) {
            for (int i = 0; i < count; i++) {
                if (presentStudents[i].equals(name)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}
