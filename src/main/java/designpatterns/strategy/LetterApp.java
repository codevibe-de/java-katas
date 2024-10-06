package designpatterns.strategy;

import java.time.LocalDate;

public class LetterApp {

    public static void main(String[] args) {
        Letter letter = new Letter("John", "Doe", LocalDate.of(2024, 12, 24));

        System.out.println("-".repeat(80));

        String content = letter.generateContent(GreetingStrategy.FORMAL);
        System.out.println(content);

        System.out.println("-".repeat(80));

        content = letter.generateContent(GreetingStrategy.INFORMAL);
        System.out.println(content);

        System.out.println("-".repeat(80));
    }

}
