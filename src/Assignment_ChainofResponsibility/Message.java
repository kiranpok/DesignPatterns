package Assignment_ChainofResponsibility;

public class Message {
    MessageType messageType;
    String content;
    String email;

    public Message(MessageType messageType, String content, String email) {
        this.messageType = messageType;
        this.content = content;
        this.email = email;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getContent() {
        return content;
    }

    public String getEmail() {
        return email;
    }
}
