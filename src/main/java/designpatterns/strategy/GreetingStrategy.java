package designpatterns.strategy;

public enum GreetingStrategy {

    FORMAL {
        @Override
        public String generateGreeting(String recipientFirstName, String recipientLastName) {
            return "Dear " + recipientFirstName + " " + recipientLastName + ",";
        }
    },
    INFORMAL {
        @Override
        public String generateGreeting(String recipientFirstName, String recipientLastName) {
            return "Hi " + recipientFirstName + ",";
        }
    };

    public abstract String generateGreeting(String recipientFirstName, String recipientLastName);

}
