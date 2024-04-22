package Assignment_ChainofResponsibility;

public abstract class Feedback {

    private Feedback nextFeedback;

    public void process(Message message) {
        if (nextFeedback != null) {
            nextFeedback.process(message);
        }
    }

    public void setNextFeedback(Feedback feedback) {
        this.nextFeedback = feedback;
    }

    public Feedback getNextFeedback() {
        return nextFeedback;
    }
}
