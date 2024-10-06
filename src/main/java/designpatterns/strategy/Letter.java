package designpatterns.strategy;

import java.time.LocalDate;

public class Letter {

    private final String recipientFirstName;
    private final String recipientLastName;
    private final LocalDate deadline;

    public Letter(String recipientFirstName, String recipientLastName,
                  LocalDate deadline) {
        this.recipientFirstName = recipientFirstName;
        this.recipientLastName = recipientLastName;
        this.deadline = deadline;
    }


    public String generateContent(GreetingStrategy greetingStrategy) {
        var greeting = greetingStrategy.generateGreeting(recipientFirstName, recipientLastName);
        return """
                %s
                
                I am writing to inform you that the deadline for the project has been extended to %s.
                
                Take care, your Java Bot
                """.formatted(greeting, deadline);
    }
}
