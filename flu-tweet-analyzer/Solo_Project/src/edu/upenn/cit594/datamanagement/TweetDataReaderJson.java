package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.Tweet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read tweet data from a JSON file.
 */
public class TweetDataReaderJson extends TweetDataReader {

    /**
     * Constructor to initialize the file path.
     *
     * @param filePath Path to the tweet data file.
     */
    public TweetDataReaderJson(String filePath) {
        super(filePath);
    }

    /**
     * Reads tweets from the JSON file.
     *
     * @return List of tweets.
     */
    @Override
    public List<Tweet> readTweets() {
        List<Tweet> tweets = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filePath));
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                JSONArray location = (JSONArray) jsonObject.get("location");
                double latitude = (double) location.get(0);
                double longitude = (double) location.get(1);
                String text = (String) jsonObject.get("text");
                tweets.add(new Tweet(latitude, longitude, text)); // Create a new Tweet object and add it to the list
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }
        return tweets; // Return the list of tweets
    }
}
