package designpatterns.strategy;

import java.time.LocalDate;

public class FormalLetter extends Letter {

    public FormalLetter(String recipientFirstName, String recipientLastName,
                        LocalDate deadline) {
        super(recipientFirstName, recipientLastName, deadline);
    }


    @Override
    public String generateGreeting(String recipientFirstName, String recipientLastName) {
        return "Dear " + recipientFirstName + " " + recipientLastName + ",";
    }

}
