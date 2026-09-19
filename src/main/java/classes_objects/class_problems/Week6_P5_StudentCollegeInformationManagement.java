package classes_objects.class_problems;

public class Week6_P5_StudentCollegeInformationManagement {

    static class Student {
        String name;
        double attendance;
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        Student(String name, double attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        new Student("Ishwar", 90);
        new Student("Rahul", 85);

        System.out.println("2 Student objects created");
        Student.printCollegeInfo();
    }
}
