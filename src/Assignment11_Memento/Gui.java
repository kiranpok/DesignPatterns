package Assignment11_Memento;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

import java.util.List;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);

        Label labelUndo = new Label("Press Ctrl + Z to undo the last change.");
        Label labelRedo = new Label("Press Ctrl + Y to redo the last change.");
        labelUndo.setPadding(insets);
        labelRedo.setPadding(insets);

        Button stateHistoryButton = new Button("Display State History");
        stateHistoryButton.setOnAction(actionEvent -> displayStateHistory());

        VBox historyButtonBox = new VBox();
        historyButtonBox.setPadding(insets);
        historyButtonBox.getChildren().addAll(stateHistoryButton);

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox, labelUndo, labelRedo, historyButtonBox);

        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);

        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                // Ctrl-Z: undo
                System.out.println("Undo key combination pressed");
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                // Ctrl-Y
                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    public void displayStateHistory() {
        Stage historyStage = new Stage();
        historyStage.setTitle("State History");

        ListView<String> listView = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList();

        List<IMemento> historyList = controller.getHistoryList();
        for (IMemento memento : historyList) {
            items.add(memento.toString());
        }
        listView.setItems(items);

        listView.setOnMouseClicked(mouseEvent -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < historyList.size()) {
                controller.restoreState(historyList.get(selectedIndex));
            }
        });

        Scene scene = new Scene(listView, 300, 600);
        historyStage.setScene(scene);
        historyStage.show();
    }
}