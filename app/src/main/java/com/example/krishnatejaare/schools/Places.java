package com.example.krishnatejaare.schools;

/**
 * Created by Krishna Teja Are on 4/16/2018.
 */

import android.view.View;
import android.widget.EditText;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Places {

    public List<PlacesReadTask> parse(JSONObject jsonObject) {
        JSONArray jsonArray = null;
        try {
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getPlaces(jsonArray);
    }

    private List<PlacesReadTask> getPlaces(JSONArray jsonArray) {
        int placesCount = jsonArray.length();
        List<PlacesReadTask> placesList = new ArrayList<PlacesReadTask>();
        PlacesReadTask placeMap = null;

        for (int i = 0; i < placesCount; i++) {
            try {
                placeMap = getPlace((JSONObject) jsonArray.get(i));
                placesList.add(placeMap);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        System.out.println("500");
        System.out.println(placesList);
        return placesList;
    }

    private PlacesReadTask getPlace(JSONObject googlePlaceJson) {
        //HashMap<String, String> googlePlaceMap = new HashMap<String, String>();
        PlacesReadTask record=new PlacesReadTask();;
        String placeName = "-NA-";
        String id = "-NA-";
        String latitude = "";
        String longitude = "";
        String reference = "";
        String rating="";

        try {
            if (!googlePlaceJson.isNull("name")) {
                placeName = googlePlaceJson.getString("school_name");
            }
            if (!googlePlaceJson.isNull("vicinity")) {
                id = googlePlaceJson.getString("dbn");
            }

            record.setSchool_name(placeName);
            record.setId(id);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return record;
    }

}
