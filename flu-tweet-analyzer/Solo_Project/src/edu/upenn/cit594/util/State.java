package edu.upenn.cit594.util;

/**
 * Represents a State with a name and coordinates of its geographical center.
 */
public class State {
    private String name; // Name of the state
    private double latitude; // Latitude of the state's geographical center
    private double longitude; // Longitude of the state's geographical center

    /**
     * Constructor to initialize a State object.
     *
     * @param name      Name of the state.
     * @param latitude  Latitude of the state's geographical center.
     * @param longitude Longitude of the state's geographical center.
     */
    public State(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Gets the name of the state.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the latitude of the state's geographical center.
     *
     * @return The latitude.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Gets the longitude of the state's geographical center.
     *
     * @return The longitude.
     */
    public double getLongitude() {
        return longitude;
    }
}