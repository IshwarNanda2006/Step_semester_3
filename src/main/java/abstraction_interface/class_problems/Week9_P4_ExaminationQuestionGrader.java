package abstraction_interface.class_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week9_P4_ExaminationQuestionGrader {
    abstract static class Question {
        final String correct, answer;
        final double points;
        Question(String correct, String answer, double points) { this.correct = correct; this.answer = answer; this.points = points; }
        abstract double score();
    }
    static class ExactQuestion extends Question {
        ExactQuestion(String correct, String answer, double points) { super(correct, answer, points); }
        double score() { return correct.equals(answer) ? points : 0.0; }
    }
    static class EssayQuestion extends Question {
        EssayQuestion(String correct, String answer, double points) { super(correct, answer, points); }
        double score() {
            int matches = 0;
            String answerLower = answer.toLowerCase(Locale.ROOT);
            for (String keyword : correct.split(",")) {
                String key = keyword.trim().toLowerCase(Locale.ROOT);
                if (!key.isEmpty() && answerLower.contains(key)) matches++;
            }
            if (matches >= 2) return points * 0.75;
            if (matches == 1) return points * 0.50;
            return 0.0;
        }
    }

    static String readLine(BufferedReader br) throws Exception {
        String line;
        while ((line = br.readLine()) != null) if (!line.trim().isEmpty()) return line.trim();
        return null;
    }

    static List<String> tokenize(String line) {
        List<String> result = new ArrayList<>();
        Matcher matcher = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        while (matcher.find()) result.add(matcher.group(1) != null ? matcher.group(1) : matcher.group(2));
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(readLine(br));
        double total = 0;
        for (int i = 0; i < n; i++) {
            List<String> t = tokenize(readLine(br));
            String type = t.get(0).toUpperCase(Locale.ROOT);
            String correct = t.get(2);
            String answer = t.get(3);
            double points = t.size() > 4 ? Double.parseDouble(t.get(4)) : 1.0;
            Question q = type.equals("ESSAY") ? new EssayQuestion(correct, answer, points) : new ExactQuestion(correct, answer, points);
            double score = q.score();
            System.out.printf(Locale.US, "%s: %.2f%n", type, score);
            total += score;
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}
