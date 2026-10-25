package abstraction_interface.class_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Locale;

public class Week9_P2_LibraryItemDueDateCalculator {
    abstract static class LibraryItem {
        final String title;
        LibraryItem(String title) { this.title = title; }
        abstract int loanDays();
        LocalDate dueDate() { return LocalDate.of(2023, 10, 26).plusDays(loanDays()); }
    }
    static class Book extends LibraryItem { Book(String title) { super(title); } int loanDays() { return 14; } }
    static class Dvd extends LibraryItem { Dvd(String title) { super(title); } int loanDays() { return 7; } }
    static class Magazine extends LibraryItem { Magazine(String title) { super(title); } int loanDays() { return 3; } }

    static String readLine(BufferedReader br) throws Exception {
        String line;
        while ((line = br.readLine()) != null) if (!line.trim().isEmpty()) return line.trim();
        return null;
    }

    static LibraryItem create(String type, String title) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "BOOK": return new Book(title);
            case "DVD": return new Dvd(title);
            case "MAGAZINE": return new Magazine(title);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(readLine(br));
        for (int i = 0; i < n; i++) {
            String line = readLine(br);
            int split = line.indexOf(' ');
            String type = line.substring(0, split).trim();
            String title = line.substring(split + 1).trim();
            if (title.startsWith("\"") && title.endsWith("\"") && title.length() >= 2) title = title.substring(1, title.length() - 1);
            LibraryItem item = create(type, title);
            System.out.println(item.title + ": " + item.dueDate());
        }
    }
}
