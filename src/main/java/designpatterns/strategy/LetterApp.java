package designpatterns.strategy;

import java.time.LocalDate;

public class LetterApp {

    public static void main(String[] args) {
        System.out.println("-".repeat(80));

        Letter letter = new FormalLetter("John", "Doe", LocalDate.of(2024, 12, 24));
        String content = letter.generateContent();
        System.out.println(content);

        System.out.println("-".repeat(80));

        letter = new InformalLetter("John", "Doe", LocalDate.of(2024, 12, 24));
        content = letter.generateContent();
        System.out.println(content);

        System.out.println("-".repeat(80));
    }

}
