package Assignment6_Decorator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilePrinterDecorator extends PrinterDecorator{
    public FilePrinterDecorator(Printer printer) {
        super(printer);
    }
    @Override
    public void print(String message) {
        super.print(message);
        printToFile(message);
    }
    private void printToFile(String message) {
        String fileName = "my_file.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
