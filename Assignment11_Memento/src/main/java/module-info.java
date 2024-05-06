module com.example.assignment11_memento {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment11_memento to javafx.fxml;
    exports com.example.assignment11_memento;
}