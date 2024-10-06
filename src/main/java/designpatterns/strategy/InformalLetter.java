package designpatterns.strategy;

import java.time.LocalDate;

public class InformalLetter extends Letter {

    public InformalLetter(String recipientFirstName, String recipientLastName,
                          LocalDate deadline) {
        super(recipientFirstName, recipientLastName, deadline);
    }


    @Override
    public String generateGreeting(String recipientFirstName, String recipientLastName) {
        return "Hi " + recipientFirstName + ",";
    }

}
