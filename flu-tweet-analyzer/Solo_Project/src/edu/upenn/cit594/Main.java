package edu.upenn.cit594;

import edu.upenn.cit594.datamanagement.*;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.processor.TweetProcessor;
import edu.upenn.cit594.ui.ConsoleUI;
import edu.upenn.cit594.util.Tweet;
import edu.upenn.cit594.util.State;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java edu.upenn.cit594.Main <tweets_file> <states_file> <log_file>");
            System.exit(1);
        }

        String tweetsFile = args[0];
        String statesFile = args[1];
        String logFile = args[2];

        try {
            // Determine the type of tweet data reader based on file extension
            TweetDataReader tweetDataReader;
            if (tweetsFile.toLowerCase().endsWith(".txt")) {
                tweetDataReader = new TweetDataReaderTxt(tweetsFile);
            } else if (tweetsFile.toLowerCase().endsWith(".json")) {
                tweetDataReader = new TweetDataReaderJson(tweetsFile);
            } else {
                throw new IllegalArgumentException("Unsupported file format: " + tweetsFile);
            }

            // Read tweets and states data
            List<Tweet> tweets = tweetDataReader.readTweets();
            StateDataReader stateDataReader = new StateDataReader(statesFile);
            List<State> states = stateDataReader.readStates();

            // Initialize the logger
            Logger logger = Logger.getInstance();
            logger.setOutput(logFile);

            // Process the tweets
            TweetProcessor tweetProcessor = new TweetProcessor(tweets, states);
            Map<String, Integer> stateTweetCount = tweetProcessor.processTweets(logger);

            // Display the results
            ConsoleUI consoleUI = new ConsoleUI();
            consoleUI.displayResults(stateTweetCount);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
