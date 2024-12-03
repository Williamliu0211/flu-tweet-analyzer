package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.Tweet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read tweet data from a tab-separated text file.
 */
public class TweetDataReaderTxt extends TweetDataReader {

    /**
     * Constructor to initialize the file path.
     *
     * @param filePath Path to the tweet data file.
     */
    public TweetDataReaderTxt(String filePath) {
        super(filePath);
    }

    /**
     * Reads tweets from the tab-separated text file.
     *
     * @return List of tweets.
     */
    @Override
    public List<Tweet> readTweets() {
        List<Tweet> tweets = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t"); // Split the line into parts using tab as the delimiter
                String[] location = parts[0].replace("[", "").replace("]", "").split(", ");
                double latitude = Double.parseDouble(location[0]);
                double longitude = Double.parseDouble(location[1]);
                String text = parts[3]; // Extract the tweet text
                tweets.add(new Tweet(latitude, longitude, text)); // Create a new Tweet object and add it to the list
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }
        return tweets; // Return the list of tweets
    }
}
