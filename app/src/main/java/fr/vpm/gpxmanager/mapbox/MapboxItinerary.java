package fr.vpm.gpxmanager.mapbox;

import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;

import java.util.ArrayList;
import java.util.List;

import fr.vpm.gpxmanager.itinerary.Itinerary;
import fr.vpm.gpxmanager.itinerary.Position;

/**
 * Created by vince on 10/05/16.
 */
public class MapboxItinerary {

  private final Itinerary itinerary;

  public MapboxItinerary(Itinerary itinerary) {
    this.itinerary = itinerary;
  }

  private MarkerOptions getMarker(Position position) {
    return new MarkerOptions()
        .position(new LatLng(position.getLatitude(), position.getLongitude()))
        .getThis();
  }

  public List<MarkerOptions> getMarkers() {
    List<MarkerOptions> markers = new ArrayList<>();
    for (Position position : itinerary.getPositions()) {
      markers.add(getMarker(position));
    }
    return markers;
  }
}
