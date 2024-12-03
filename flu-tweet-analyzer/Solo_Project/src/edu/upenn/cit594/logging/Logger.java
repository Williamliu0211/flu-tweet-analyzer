package edu.upenn.cit594.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance; // Singleton instance of Logger
    private PrintWriter out; // PrintWriter to write logs to the file

    // Private constructor to prevent external instantiation
    private Logger() {
    }

    // Method to get the singleton instance of Logger
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to set or change the output file for the logger
    public void setOutput(String filename) {
        try {
            if (out != null) {
                out.close();
            }
            // Initialize PrintWriter to append to the specified file
            out = new PrintWriter(new FileWriter(filename, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to log messages to the file
    public void log(String message) {
        out.println(message); // Write the message to the file
        out.flush(); // Flush the writer to ensure the message is written immediately
    }

    // Overloaded log method to log messages with state and tweet text
    public void log(String state, String tweetText) {
        out.println(state + "\t" + tweetText); // Write the state and tweet text to the file in the expected format
        out.flush(); // Flush the writer to ensure the message is written immediately
    }
}
