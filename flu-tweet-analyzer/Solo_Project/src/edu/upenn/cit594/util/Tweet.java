package edu.upenn.cit594.util;

/**
 * Represents a Tweet with a location and text.
 */
public class Tweet {
    private double latitude; // Latitude of the tweet's location
    private double longitude; // Longitude of the tweet's location
    private String text; // Text of the tweet

    /**
     * Constructor to initialize a Tweet object.
     *
     * @param latitude
     * @param longitude
     * @param text
     */
    public Tweet(double latitude, double longitude, String text) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.text = text;
    }

    /**
     * Gets the latitude of the tweet's location.
     *
     * @return The latitude.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Gets the longitude of the tweet's location.
     *
     * @return The longitude.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Gets the text of the tweet.
     *
     * @return The text.
     */
    public String getText() {
        return text;
    }
}