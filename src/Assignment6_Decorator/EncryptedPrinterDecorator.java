package Assignment6_Decorator;

public class EncryptedPrinterDecorator extends PrinterDecorator{
    public EncryptedPrinterDecorator(Printer printer) {
        super(printer);
    }
    @Override
    public void print(String message) {
        super.print(encrypt(message));
    }
    private String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            encrypted.append((char) (c + 1));
        }
        return "Encrypted Message: " + encrypted;
    }


}
