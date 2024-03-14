package Assignment2_AbstractFactory;

public class Main {
    public static void main(String[] args) {
        // Create a UIFactory of Style A
        UIFactory factoryA = new AFactory();

        // Create UI Elements using Style A
        Button buttonA = factoryA.createButton("Click me");
        TextField textFieldA = factoryA.createTextField("Enter text");
        Checkbox checkboxA = factoryA.createCheckbox("Agree");

        // Display UI Elements
        buttonA.display();
        textFieldA.display();
        checkboxA.display();

        // Change content dynamically
        buttonA.setText("New Text");
        buttonA.display();
    }
}
