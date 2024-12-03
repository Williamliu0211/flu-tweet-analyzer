package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.State;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read state data from a CSV file.
 */
public class StateDataReader {
    private String filePath; // Path to the state data file

    /**
     * Constructor to initialize the file path.
     *
     * @param filePath Path to the state data file.
     */
    public StateDataReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads states from the CSV file.
     *
     * @return List of states.
     */
    public List<State> readStates() {
        List<State> states = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Split the line into parts using comma as the delimiter
                String name = parts[0]; // Extract the state name
                double latitude = Double.parseDouble(parts[1]);
                double longitude = Double.parseDouble(parts[2]);
                states.add(new State(name, latitude, longitude)); // Create a new State object and add it to the list
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }
        return states; // Return the list of states
    }
}
