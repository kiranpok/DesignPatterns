package Assignment_ChainofResponsibility;

public class GeneralFeedback extends Feedback {

    @Override
    public void process(Message message) {
        if (message.messageType == MessageType.GENERAL_FEEDBACK) {
            System.out.println("Your Suggestion: " + message.content + " has been acknowledged!");
            System.out.println(
                    "Thank you for providing the feedback.\nAny contact will be made to the mail: " + message.email);
            System.out.println();
        } else {
            // System response
            System.out.println("This is not a General Feedback. Message is forwarded!");
            this.getNextFeedback().process(message);
        }
    }
}
