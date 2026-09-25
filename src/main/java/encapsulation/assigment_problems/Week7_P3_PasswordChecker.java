package encapsulation.assigment_problems;

public class Week7_P3_PasswordChecker {

    static class PasswordChecker {
        private final String password;

        PasswordChecker(String password) {
            this.password = password;
        }

        String getStrength() {
            int length = password.length();

            if (length < 6) {
                return "Weak";
            } else if (length <= 9) {
                return "Medium";
            } else {
                return "Strong";
            }
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        PasswordChecker pc2 = new PasswordChecker("abcdefghij");

        System.out.println("Password 1: " + pc.getStrength());
        System.out.println("Password 2: " + pc2.getStrength());
    }
}
