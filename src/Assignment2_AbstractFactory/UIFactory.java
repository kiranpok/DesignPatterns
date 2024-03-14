package Assignment2_AbstractFactory;

abstract class UIFactory {
    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract Checkbox createCheckbox(String text);
}
