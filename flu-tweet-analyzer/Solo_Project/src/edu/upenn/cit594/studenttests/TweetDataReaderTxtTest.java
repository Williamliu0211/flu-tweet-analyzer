package edu.upenn.cit594.studenttests;

import edu.upenn.cit594.datamanagement.TweetDataReaderTxt;
import edu.upenn.cit594.util.Tweet;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TweetDataReaderTxtTest {

    @Test
    public void testReadTweets() {
        TweetDataReaderTxt reader = new TweetDataReaderTxt("flu_tweets.txt");
        List<Tweet> tweets = reader.readTweets();
        assertNotNull(tweets); // Check that the list of tweets is not null
        assertEquals(10000, tweets.size()); // Check that the list contains the expected number of tweets
    }
}
