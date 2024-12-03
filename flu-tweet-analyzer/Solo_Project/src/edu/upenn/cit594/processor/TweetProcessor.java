package edu.upenn.cit594.processor;

import edu.upenn.cit594.util.Tweet;
import edu.upenn.cit594.util.State;
import edu.upenn.cit594.logging.Logger;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Class to process tweets and determine the states from which flu tweets
 * originate.
 */
public class TweetProcessor {
    private List<Tweet> tweets; // List of tweets to be processed
    private List<State> states; // List of states with their geographical centers

    /**
     * Constructor to initialize the TweetProcessor.
     *
     * @param tweets List of tweets.
     * @param states List of states.
     */
    public TweetProcessor(List<Tweet> tweets, List<State> states) {
        this.tweets = tweets;
        this.states = states;
    }

    /**
     * Processes tweets to identify flu-related tweets, logs them, and counts the
     * number of flu tweets per state.
     *
     * @param logger The logger instance for logging flu tweets.
     * @return Map of state names to the number of flu tweets.
     */
    public Map<String, Integer> processTweets(Logger logger) {
        Map<String, Integer> stateTweetCount = new TreeMap<>(); // Map to count flu tweets per state, sorted by state
                                                                // name
        for (Tweet tweet : tweets) {
            if (isFluTweet(tweet.getText())) { // Check if the tweet is flu-related
                String state = findStateForTweet(tweet); // Determine the state for the tweet
                if (state != null) {
                    if (logger != null) {
                        logger.log(state, tweet.getText()); // Log the flu tweet
                    }
                    stateTweetCount.put(state, stateTweetCount.getOrDefault(state, 0) + 1); // Increment the count for
                                                                                            // the state
                }
            }
        }
        return stateTweetCount; // Return the map of state names to the number of flu tweets
    }

    /**
     * Determines if a tweet is flu-related based on its text.
     *
     * @param text The text of the tweet.
     * @return True if the tweet is flu-related, false otherwise.
     */
    private boolean isFluTweet(String text) {
        // Regular expression to match flu-related words or hashtags
        String regex = "\\b(#[fF][lL][uU]|[fF][lL][uU])(\\W|$)";
        Pattern pattern = Pattern.compile(regex); // Compile the regular expression
        Matcher matcher = pattern.matcher(text); // Match the text against the regular expression
        return matcher.find(); // Return true if a match is found, false otherwise
    }

    /**
     * Finds the nearest state for a given tweet based on its location.
     *
     * @param tweet The tweet for which to find the state.
     * @return The name of the nearest state, or null if no state is found.
     */
    private String findStateForTweet(Tweet tweet) {
        double minDistance = Double.MAX_VALUE; // Initialize the minimum distance to a very large value
        String nearestState = null; // Initialize the nearest state to null
        for (State state : states) {
            double distance = calculateDistance(tweet.getLatitude(), tweet.getLongitude(), state.getLatitude(),
                    state.getLongitude()); // Calculate the distance between the tweet and the state
            if (distance < minDistance) {
                minDistance = distance; // Update the minimum distance
                nearestState = state.getName(); // Update the nearest state
            }
        }
        return nearestState; // Return the name of the nearest state
    }

    /**
     * Calculates the distance between two geographical points using the Euclidean
     * distance formula.
     *
     * @param lat1 Latitude of the first point.
     * @param lon1 Longitude of the first point.
     * @param lat2 Latitude of the second point.
     * @param lon2 Longitude of the second point.
     * @return The distance between the two points.
     */
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Calculate the Euclidean distance between two points
        double latDistance = lat2 - lat1;
        double lonDistance = lon2 - lon1;
        return Math.sqrt(latDistance * latDistance + lonDistance * lonDistance); // Return the calculated distance
    }
}
