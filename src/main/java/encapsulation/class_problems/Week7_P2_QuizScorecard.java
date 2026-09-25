package encapsulation.class_problems;

public class Week7_P2_QuizScorecard {

    static class Scorecard {
        private final boolean[] results;
        private int recordedCount;

        Scorecard(int questionCount) {
            results = new boolean[questionCount];
            recordedCount = 0;
        }

        void recordAnswer(boolean correct) {
            if (recordedCount < results.length) {
                results[recordedCount] = correct;
                recordedCount++;
            }
        }

        int getScore() {
            int score = 0;

            for (int i = 0; i < recordedCount; i++) {
                if (results[i]) {
                    score++;
                }
            }

            return score;
        }
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}
