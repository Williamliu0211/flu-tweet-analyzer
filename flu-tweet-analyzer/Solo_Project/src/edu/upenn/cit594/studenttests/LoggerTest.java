package edu.upenn.cit594.studenttests;

import edu.upenn.cit594.logging.Logger;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerTest {

    @Test
    public void testLog() throws IOException {
        Logger logger = Logger.getInstance();
        logger.setOutput("test_log.txt");
        logger.log("TestState", "This is a test tweet");

        BufferedReader reader = new BufferedReader(new FileReader("test_log.txt"));
        String line;
        boolean found = false;
        while ((line = reader.readLine()) != null) {
            if (line.equals("TestState: This is a test tweet")) {
                found = true; // Check if the expected log entry is found
                break;
            }
        }
        reader.close();
        assertTrue(found); // Verify that the log entry was found
    }
}
