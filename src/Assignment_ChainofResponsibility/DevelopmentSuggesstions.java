package Assignment_ChainofResponsibility;

public class DevelopmentSuggestions extends Feedback {

    @Override
    public void process(Message message) {
        if (message.messageType == MessageType.DEVELOPMENT_SUGGESTIONS) {
            System.out.println("Your Suggestion: " + message.content + " has been acknowledged!");
            System.out.println("You can participate in promo campaign by clicking the code sent to: " + message.email);
            System.out.println();
        } else {
            // System response
            System.out.println("This is not a Development Suggestion. Message is forwarded!");
            this.getNextFeedback().process(message);
        }
    }
}