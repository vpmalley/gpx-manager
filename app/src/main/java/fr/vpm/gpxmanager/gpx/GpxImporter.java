package fr.vpm.gpxmanager.gpx;


import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

import fr.vpm.gpxmanager.itinerary.Itinerary;
import fr.vpm.gpxmanager.itinerary.Position;
import io.ticofab.androidgpxparser.parser.GPXParser;
import io.ticofab.androidgpxparser.parser.domain.Gpx;
import io.ticofab.androidgpxparser.parser.domain.Track;
import io.ticofab.androidgpxparser.parser.domain.TrackPoint;
import io.ticofab.androidgpxparser.parser.domain.TrackSegment;

/**
 * Created by vince on 10/05/16.
 */
public class GpxImporter {

  private GPXParser gpxParser = new GPXParser();

  public Itinerary loadGPXAsset(Context context) {
    Itinerary itinerary = null;
    try {
      Gpx gpx = gpxParser.parse(context.getAssets().open("gr1a.gpx"));
      List<Track> tracks = gpx.getTracks();
      List<TrackSegment> segments = tracks.get(0).getTrackSegments();
      itinerary = extractItinerary(segments.get(0));
    } catch (XmlPullParserException e) {
      Log.e("gpx", "opening GPX");
    } catch (IOException e) {
      Log.e("gpx", "opening GPX");
    }
    return itinerary;
  }

  private Itinerary extractItinerary(TrackSegment trackSegment) {
    Itinerary itinerary = new Itinerary();
    for (TrackPoint trackPoint : trackSegment.getTrackPoints()) {
      itinerary.addPosition(new Position(trackPoint.getLatitude(), trackPoint.getLongitude()));
    }
    return itinerary;
  }

}
