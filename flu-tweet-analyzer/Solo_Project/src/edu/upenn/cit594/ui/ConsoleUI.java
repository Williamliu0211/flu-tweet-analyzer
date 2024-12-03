package edu.upenn.cit594.ui;

import java.util.Map;

/**
 * Class to handle user interaction through the console.
 */
public class ConsoleUI {

    /**
     * Displays the number of flu tweets per state to the console.
     *
     * @param stateTweetCount Map of state names to the number of flu tweets.
     */
    public void displayResults(Map<String, Integer> stateTweetCount) {
        for (Map.Entry<String, Integer> entry : stateTweetCount.entrySet()) {
            // Print each state and the corresponding number of flu tweets
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
