package Assignment5_singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;
    private String fileName;
    private PrintWriter writer;

    private Logger() {
        this.fileName = "default_log.txt";
        try {
            this.writer = new PrintWriter(new FileWriter(fileName, true)); // Append mode
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void setFileName(String fileName) {
        closeFile();
        this.fileName = fileName;
        openFile();
    }

    private void openFile() {
        try {
            this.writer = new PrintWriter(new FileWriter(fileName, true)); // Append mode
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeFile() {
        if (writer != null) {
            writer.close();
        }
    }

    public synchronized void write(String message) {
        writer.println(message);
    }

    public synchronized void close() {
        closeFile();
    }
}
