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

public class DetailsDisplayTask extends AsyncTask<Object, Integer, List<ResultsReadTask>>  {
    public static List<ResultsReadTask> recordsnew;
    JSONObject googlePlacesJson;
    private int id;
    public AsyncResponse delegate = null;

    public DetailsDisplayTask(int id) {
        this.id = id;
    }

    @Override
    protected List<ResultsReadTask> doInBackground(Object... inputObj) {

        List<ResultsReadTask> googlePlacesList = null;
        Details placeJsonParser = new Details();

        try {
            googlePlacesJson = new JSONObject((String) inputObj[0]);
            googlePlacesList = placeJsonParser.parse(googlePlacesJson);
        } catch (Exception e) {
            Log.d("Exception", e.toString());
        }
        return googlePlacesList;
    }

    @Override
    protected void onPostExecute(List<ResultsReadTask> list) {
        Object[] toPass = new Object[1];
        toPass[0] = list;
        delegate.onProcessFinish(toPass, id);
    }

}
