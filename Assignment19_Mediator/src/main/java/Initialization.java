import javafx.application.Application;
import javafx.stage.Stage;

public class Initialization extends Application {
    @Override
    public void start(Stage stage) {
        Mediator mediator = new ChatMediator();

        Controller controller1 = new ChatController("User 1", mediator);
        Controller controller2 = new ChatController("User 2", mediator);
        Controller controller3 = new ChatController("User 3", mediator);

//        mediator.addClient(controller1.getUsername(), controller1);
//        mediator.addClient(controller2.getUsername(), controller2);
//        mediator.addClient(controller3.getUsername(), controller3);

        new ChatWindow((ChatController) controller1).start(new Stage());
        new ChatWindow((ChatController) controller2).start(new Stage());
        new ChatWindow((ChatController) controller3).start(new Stage());
    }
}
