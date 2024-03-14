package Assignment5_singleton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setFileName("new_log.txt"); // Change file name

        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");
        logger.close(); // Remember to close the logger

        // Display the content of the log file
        try (BufferedReader reader = new BufferedReader(new FileReader("new_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}