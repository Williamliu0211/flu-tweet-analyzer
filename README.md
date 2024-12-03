# CIT 594 Solo Project: Flu Tweet Analyzer

## Overview
This project demonstrates software design and development principles by analyzing tweets to identify flu-related content and determine the origin states of the tweets within the U.S.

The application processes input data files in either tab-separated or JSON format, extracts relevant tweets, and outputs the number of flu-related tweets per state. It also logs flu-related tweets in a structured format.

---

## Features
- **Multi-format Input**: Supports `.txt` (tab-separated) and `.json` (JSON) input files.
- **Flu Tweet Detection**: Identifies tweets mentioning "flu" or related hashtags using regex-based text analysis.
- **State Mapping**: Determines the U.S. state of origin for tweets using latitude/longitude data and a state center point file.
- **Logging**: Logs flu-related tweets to a specified file.
- **N-tier Architecture**: Implements a modular design using presentation, processing, data management, and logging tiers.

---

## Learning Objectives
This project aims to:
- Design a software system using an N-tier architecture.
- Apply principles of modularity, functional independence, and abstraction.
- Implement the Singleton design pattern.
- Utilize JSON libraries to parse data.

---

## File Structure
```
src/
├── edu/upenn/cit594/
│   ├── Main.java                   # Entry point of the program
│   ├── datamanagement/             # Data management classes
│   │   ├── StateDataReader.java    # Reads state center points from CSV
│   │   ├── TweetDataReaderJson.java # Reads tweets from JSON
│   │   └── TweetDataReaderTxt.java # Reads tweets from tab-separated files
│   ├── logging/                    # Singleton Logger
│   │   └── Logger.java
│   ├── processor/                  # Processing logic
│   │   └── TweetProcessor.java     # Processes tweet data
│   ├── ui/                         # User interface tier
│   │   └── ConsoleUI.java          # Handles runtime interactions
│   └── util/                       # Utility classes
│       ├── State.java              # Represents a U.S. state
│       └── Tweet.java              # Represents a tweet
tests/
├── BasicTests.java                 # Unit tests for basic functionality
├── LoggerTest.java                 # Tests for the Logger
├── StateDataReaderTest.java        # Tests for StateDataReader
├── TweetDataReaderJsonTest.java    # Tests for JSON Tweet reader
├── TweetDataReaderTxtTest.java     # Tests for TXT Tweet reader
└── TweetProcessorTest.java         # Tests for TweetProcessor
```

---

## Input Data
- **Tweets**:
  - `flu_tweets.txt` (Tab-separated format)
  - `flu_tweets.json` (JSON format)
- **States**: `states.csv` (List of U.S. states with latitude and longitude of their centers)

---

## How to Run
The program takes three runtime arguments:
1. Path to the tweets file (`flu_tweets.txt` or `flu_tweets.json`)
2. Path to the states file (`states.csv`)
3. Path to the log file (e.g., `log.txt`)

### Example Command
```bash
java edu.upenn.cit594.Main flu_tweets.json states.csv log.txt
```

### Expected Output
- **Console**: Number of flu-related tweets per state in alphabetical order.
- **Log File**: Flu-related tweets with their corresponding state and tweet text.

---

## Design Highlights
### N-tier Architecture
- **UI Tier**: Handles input arguments and user interactions.
- **Processing Tier**: Detects flu-related tweets and maps them to states.
- **Data Management Tier**: Reads and parses input files.
- **Logging Tier**: Implements the Singleton pattern for logging.

### Logging
- Flu-related tweets are logged with the format: `StateName\tTweetText`
- Logs are appended to the specified file without overwriting existing content.

---

## Dependencies
- **Java 11**: Use the Java Development Kit (JDK) 11.
- **JSON.simple Library**: For reading and parsing JSON files (`json-simple-1.1.1.jar`).

---

## Testing
Run tests in the `tests/` directory to validate individual components and integration:
```bash
javac -cp .:json-simple-1.1.1.jar tests/*.java
java -cp .:json-simple-1.1.1.jar tests.BasicTests
```

---

## Common Issues
- Ensure the input files are well-formed and located in the correct directory.
- Verify that the log file path is writable.
- Use the correct regex patterns for flu detection (`"flu\\b"`).

---

## License
This project is distributed for educational purposes. Contact the author for permissions beyond this scope.

---

## Contact
**Author**: Wiiliam Liu  
**Email**: Xuanjliu@seas.upenn.edu
