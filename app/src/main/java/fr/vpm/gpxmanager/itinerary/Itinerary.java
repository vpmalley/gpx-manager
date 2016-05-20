package fr.vpm.gpxmanager.itinerary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vince on 09/05/16.
 */
public class Itinerary {

  private final List<Position> positions = new ArrayList<>();

  public void addPosition(Position position) {
    positions.add(position);
  }

  public List<Position> getPositions() {
    return positions;
  }
}
