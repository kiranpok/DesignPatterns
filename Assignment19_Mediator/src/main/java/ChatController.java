public class ChatController implements Controller {
    private String username;
    private Mediator mediator;
    private ChatWindow window;

    public ChatController(String username, Mediator mediator) {
        this.username = username;
        this.mediator = mediator;

        mediator.addClient(username, this);
    }

    public void setWindow(ChatWindow window) {
        this.window = window;
    }

    public String getUsername() {
        return username;
    }

    public Mediator getMediator() {
        return mediator;
    }

    @Override
    public void sendMessage(String recipient, String message) {
        mediator.sendMessage(username, recipient, message);
        if (window != null) {
            window.updateChatArea(username, message);
        }
    }

    @Override
    public void sendToAll(String message) {
        mediator.sendToAll(username, message);
        if (window != null) {
            window.updateChatArea(username, message);
        }
    }

    @Override
    public void receiveMessage(String sender, String message) {
        if (window != null) {
            window.updateChatArea(sender, message);
        }
    }
}
