package fr.vpm.gpxmanager.itinerary;

/**
 * Created by vince on 09/05/16.
 */
public class Position {

  private final double latitude;

  private final double longitude;

  public Position(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public double getLatitude() {
    return latitude;
  }
}
