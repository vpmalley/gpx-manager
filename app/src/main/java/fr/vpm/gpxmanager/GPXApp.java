package fr.vpm.gpxmanager;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Created by vince on 11/05/16.
 */
public class GPXApp extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    JodaTimeAndroid.init(this);
  }
}
