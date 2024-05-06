public interface Controller {
    void sendMessage(String recipient, String message);
    void sendToAll(String message);
    void receiveMessage(String sender, String message);
}