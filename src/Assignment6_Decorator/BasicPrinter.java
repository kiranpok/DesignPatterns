package Assignment6_Decorator;

public class BasicPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
