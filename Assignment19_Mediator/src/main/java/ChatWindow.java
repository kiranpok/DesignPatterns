import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatWindow extends Application {
    private String username;
    private Mediator mediator;
    private Controller controller;
    private TextArea chatArea;
    private TextField messageField;
    private ToggleGroup recipientToggleGroup;

    public ChatWindow(ChatController controller) {
        this.controller = controller;
        this.mediator = controller.getMediator();
        this.username = controller.getUsername();

        controller.setWindow(this);
    }

    @Override
    public void start(Stage stage) {
        Label chatAreaLabel = new Label("Chat:");
        chatArea = new TextArea();
        chatArea.setEditable(false);

        Label messageFieldLabel = new Label("New Message:");
        messageField = new TextField();

        VBox recipientBox = new VBox();
        recipientToggleGroup = new ToggleGroup();

        Label recipientLabel = new Label("To: ");
        recipientBox.getChildren().add(recipientLabel);

        RadioButton allRadioButton = new RadioButton("All");
        allRadioButton.setToggleGroup(recipientToggleGroup);
        recipientBox.getChildren().add(allRadioButton);
        allRadioButton.setSelected(true);

        for (String recipient : mediator.getClients().keySet()) {
            RadioButton radioButton = new RadioButton(recipient);
            radioButton.setToggleGroup(recipientToggleGroup);
            recipientBox.getChildren().add(radioButton);
        }

        Button sendButton = new Button("Send");
        sendButton.setOnAction(event -> handleSendButton());

        VBox chatBox = new VBox(chatAreaLabel, chatArea, messageFieldLabel, messageField, recipientLabel, recipientBox, sendButton);
        chatBox.setSpacing(10);
        chatBox.setPadding(new Insets(10));
        BorderPane root = new BorderPane(chatBox);

        stage.setTitle(username);
        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }

    private void handleSendButton() {
        RadioButton selectedRadioButton = (RadioButton) recipientToggleGroup.getSelectedToggle();
        String recipient = selectedRadioButton.getText();
        String message = messageField.getText();

        if (!message.isEmpty()) {
            if (recipient.equals("All")) {
                controller.sendToAll(message);
            } else {
                controller.sendMessage(recipient, message);
            }

            messageField.clear();
        }
    }

    public void updateChatArea(String sender, String message) {
        chatArea.appendText(sender + ": " + message + "\n");
    }
}
