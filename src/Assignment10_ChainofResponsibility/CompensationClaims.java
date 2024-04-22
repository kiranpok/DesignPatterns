package Assignment_ChainofResponsibility;

public class CompensationClaims extends Feedback {

    @Override
    public void process(Message message) {
        if (message.messageType == MessageType.COMPENSATION_CLAIMS) {
            System.out.println("We have received your compensation claims with message: " + message.content);
            System.out.println("A compensation claim form has been sent to the email: " + message.email);
            System.out.println();
        } else {
            // System response
            System.out.println("This is not a Compensation Claim. Message is forwarded!");
            this.getNextFeedback().process(message);
        }
    }
}
