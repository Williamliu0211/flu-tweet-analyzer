package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.Tweet;
import java.util.List;

/**
 * Abstract class to define the common interface for reading tweet data.
 */
public abstract class TweetDataReader {
    protected String filePath; // Path to the tweet data file

    /**
     * Constructor to initialize the file path.
     *
     * @param filePath Path to the tweet data file.
     */
    public TweetDataReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Abstract method to read tweets from the file.
     *
     * @return List of tweets.
     */
    public abstract List<Tweet> readTweets();
}
