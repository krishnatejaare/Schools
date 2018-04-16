package com.example.krishnatejaare.schools;

/**
 * Created by Krishna Teja Are on 4/16/2018.
 */

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class DisplayTask extends AsyncTask<Object, Integer, List<PlacesReadTask>>  {
    public static List<PlacesReadTask> recordsnew;
    JSONObject googlePlacesJson;
    private int id;
    public AsyncResponse delegate = null;

    public DisplayTask(int id) {
        this.id = id;
    }

    @Override
    protected List<PlacesReadTask> doInBackground(Object... inputObj) {

        List<PlacesReadTask> googlePlacesList = null;
        Places placeJsonParser = new Places();

        try {
            googlePlacesJson = new JSONObject((String) inputObj[0]);
            googlePlacesList = placeJsonParser.parse(googlePlacesJson);
        } catch (Exception e) {
            Log.d("Exception", e.toString());
        }
        return googlePlacesList;
    }

    @Override
    protected void onPostExecute(List<PlacesReadTask> list) {
        Object[] toPass = new Object[1];
        toPass[0] = list;
        delegate.onProcessFinish(toPass, id);

    }

}
