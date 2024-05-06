import java.util.HashMap;
import java.util.Map;

public class ChatMediator implements Mediator {
    private Map<String, Controller> clients;

    public ChatMediator() {
        clients = new HashMap<>();
    }

    @Override
    public Map<String, Controller> getClients() {
        return clients;
    }

    @Override
    public void addClient(String username, Controller controller) {
        clients.put(username, controller);
    }

    @Override
    public void sendMessage(String sender, String recipient, String message) {
        Controller recipientController = clients.get(recipient);
        if (recipientController != null) {
            recipientController.receiveMessage(sender, message);
        } else {
            System.out.println("No controller found for recipient: " + recipient);
        }
    }

    @Override
    public void sendToAll(String sender, String message) {
        for (Map.Entry<String, Controller> entry : clients.entrySet()) {
            String recipient = entry.getKey();
            if (!recipient.equals(sender)) {
                entry.getValue().receiveMessage(sender, message);
            }
        }
    }
}
