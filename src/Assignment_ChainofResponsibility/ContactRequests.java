package Assignment_ChainofResponsibility;

public class ContactRequests extends Feedback {

    @Override
    public void process(Message message) {
        if (message.messageType == MessageType.CONTACT_REQUESTS) {
            System.out.println("You Contact Request has been acknowledged with message: " + message.content);
            System.out.println("Our customer care department will contact you on the mail: " + message.email);
            System.out.println();
        } else {
            // System response
            System.out.println("This is not a Contact Request. Message is forwarded!");
            this.getNextFeedback().process(message);
        }
    }
}