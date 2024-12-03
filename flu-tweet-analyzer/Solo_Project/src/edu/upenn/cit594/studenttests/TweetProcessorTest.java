package edu.upenn.cit594.studenttests;

import edu.upenn.cit594.datamanagement.StateDataReader;
import edu.upenn.cit594.datamanagement.TweetDataReaderTxt;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.processor.TweetProcessor;
import edu.upenn.cit594.util.Tweet;
import edu.upenn.cit594.util.State;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TweetProcessorTest {

    @Test
    public void testProcessTweets() {
        TweetDataReaderTxt tweetReader = new TweetDataReaderTxt("flu_tweets.txt");
        List<Tweet> tweets = tweetReader.readTweets();
        assertNotNull(tweets); // Check that the list of tweets is not null

        StateDataReader stateReader = new StateDataReader("states.csv");
        List<State> states = stateReader.readStates();
        assertNotNull(states); // Check that the list of states is not null

        Logger logger = Logger.getInstance();
        logger.setOutput("log.txt");
        TweetProcessor processor = new TweetProcessor(tweets, states);

        Map<String, Integer> result = processor.processTweets(logger);
        assertNotNull(result); // Check that the result map is not null
        assertFalse(result.isEmpty()); // Check that the result map is not empty
    }
}
