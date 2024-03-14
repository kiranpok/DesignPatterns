package Assignment6_Decorator;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Main {
    public static void main(String[] args) {
        Printer printer1 = new BasicPrinter();
        printer1.print("Hello, World!");

        Printer printer2 = new EncryptedPrinterDecorator(new FilePrinterDecorator(new BasicPrinter()));
        printer2.print("Hello, World!");
    }
}
