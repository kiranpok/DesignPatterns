import java.util.Map;

public interface Mediator {
    void addClient(String username, Controller controller);
    Map<String, Controller> getClients();
    void sendMessage(String sender, String recipient, String message);
    void sendToAll(String sender, String message);
}
