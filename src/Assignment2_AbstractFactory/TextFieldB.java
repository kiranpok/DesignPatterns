package Assignment2_AbstractFactory;

class TextFieldB extends TextField {
    private String text = "";

    @Override
    public void display() {
        System.out.println(" (TextFieldB) ");
        System.out.println(" " + text + " ");
        System.out.println(" ------------ ");
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
