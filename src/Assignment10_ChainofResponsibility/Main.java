package Assignment_ChainofResponsibility;

public class Main {
    public static void main(String[] args) {
        Feedback generalFeedback = new GeneralFeedback();
        Feedback developmentSuggestions = new DevelopmentSuggesstions();
        Feedback contactRequests = new ContactRequests();
        Feedback compensationClaims = new CompensationClaims();

        generalFeedback.setNextFeedback(developmentSuggestions);
        developmentSuggestions.setNextFeedback(contactRequests);
        contactRequests.setNextFeedback(compensationClaims);

        Message message1 = new Message(MessageType.COMPENSATION_CLAIMS, "Faulty Product", "customer1@123.com");
        generalFeedback.process(message1);

        Message message2 = new Message(MessageType.DEVELOPMENT_SUGGESTIONS, "Additional Item pictures!",
                "customer2@123.com");
        generalFeedback.process(message2);

        Message message3 = new Message(MessageType.GENERAL_FEEDBACK, "Good quality product", "customer3@123.com");
        generalFeedback.process(message3);
    }
}
