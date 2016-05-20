package fr.vpm.gpxmanager;

import android.media.midi.MidiOutputPort;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import java.util.List;

import fr.vpm.gpxmanager.gpx.GpxImporter;
import fr.vpm.gpxmanager.itinerary.Itinerary;
import fr.vpm.gpxmanager.mapbox.MapboxItinerary;

public class ItineraryActivity extends AppCompatActivity {

  private MapView mapview;
  private MapboxMap mapboxMap;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_itinerary);
    findViews();
    mapview.onCreate(savedInstanceState);
    mapview.getMapAsync(new OnMapReadyCallback() {
      @Override
      public void onMapReady(MapboxMap mapboxMap) {
      }
    });

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Itinerary itinerary = new GpxImporter().loadGPXAsset(ItineraryActivity.this);
        List<MarkerOptions> markers = new MapboxItinerary(itinerary).getMarkers();
        if (mapboxMap != null) {
          for (MarkerOptions marker : markers) {
            mapboxMap.addMarker(marker);
            Log.d("gpx", "added marker at " + marker.getMarker().getPosition().getLatitude());
          }
        }
      }
    });
  }

  private void findViews() {
    mapview = (MapView) findViewById(R.id.mapview);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

  }

  @Override
  protected void onResume() {
    super.onResume();
    mapview.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    mapview.onPause();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mapview.onSaveInstanceState(outState);
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    mapview.onLowMemory();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mapview.onDestroy();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_itinerary, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
