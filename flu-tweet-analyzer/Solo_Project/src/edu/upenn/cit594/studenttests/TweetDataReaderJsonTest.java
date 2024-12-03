package edu.upenn.cit594.studenttests;

import edu.upenn.cit594.datamanagement.TweetDataReaderJson;
import edu.upenn.cit594.util.Tweet;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TweetDataReaderJsonTest {

    @Test
    public void testReadTweets() {
        TweetDataReaderJson reader = new TweetDataReaderJson("flu_tweets.json");
        List<Tweet> tweets = reader.readTweets();
        assertNotNull(tweets); // Check that the list of tweets is not null
        assertEquals(10000, tweets.size()); // Check that the list contains the expected number of tweets
    }
}
