package com.example.krishnatejaare.schools;

/**
 * Created by Krishna Teja Are on 4/16/2018.
 */

import android.os.AsyncTask;
import android.util.Log;


public class ReadTask extends AsyncTask<Object, Integer, String> {
    String googlePlacesData = null;
    private static final int ASYNC_ONE = 1;

    @Override
    protected String doInBackground(Object... inputObj) {
        try {

            String googlePlacesUrl = (String) inputObj[0];
            http http = new http();
            googlePlacesData = http.read(googlePlacesUrl);
        } catch (Exception e) {
            Log.d("Google Place Read Task", e.toString());
        }
        return googlePlacesData;
    }

    @Override
    protected void onPostExecute(String result) {
        DisplayTask placesDisplayTask = new DisplayTask(ASYNC_ONE);
        Object[] toPass = new Object[1];
        toPass[0] = result;
        placesDisplayTask.execute(toPass);
    }
}