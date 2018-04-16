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

public class Details {

    public List<ResultsReadTask> parse(JSONObject jsonObject) {
        JSONArray jsonArray = null;
        try {
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getPlaces(jsonArray);
    }

    private List<ResultsReadTask> getPlaces(JSONArray jsonArray) {
        int placesCount = jsonArray.length();
        List<ResultsReadTask> placesList = new ArrayList<ResultsReadTask>();
        ResultsReadTask placeMap = null;

        for (int i = 0; i < placesCount; i++) {
            try {
                placeMap = getPlace((JSONObject) jsonArray.get(i));
                placesList.add(placeMap);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return placesList;
    }

    private ResultsReadTask getPlace(JSONObject googlePlaceJson) {
        //HashMap<String, String> googlePlaceMap = new HashMap<String, String>();
        ResultsReadTask record=new ResultsReadTask();;
         String school_name="-NA-";
         String id ="-NA-";
         String total_students="-NA-";
         String reading="-NA-";
         String math="-NA-";
         String writing="-NA-";
        try {
            if (!googlePlaceJson.isNull("school_name")) {
                school_name = googlePlaceJson.getString("school_name");
            }
            if (!googlePlaceJson.isNull("dbn")) {
                id = googlePlaceJson.getString("dbn");
            }
            if (!googlePlaceJson.isNull("num_of_sat_test_takers")) {
                total_students = googlePlaceJson.getString("num_of_sat_test_takers");
            }
            if (!googlePlaceJson.isNull("sat_critical_reading_avg_score")) {
                reading = googlePlaceJson.getString("sat_critical_reading_avg_score");
            }
            if (!googlePlaceJson.isNull("sat_math_avg_score")) {
                math = googlePlaceJson.getString("sat_math_avg_score");
            }
            if (!googlePlaceJson.isNull("sat_writing_avg_score")) {
                writing = googlePlaceJson.getString("sat_writing_avg_score");
            }


            record.setSchool_name(school_name);
            record.setId(id);
            record.setTotal_students(total_students);
            record.setWriting(writing);
            record.setMath(math);
            record.setReading(reading);



        } catch (JSONException e) {
            e.printStackTrace();
        }
        return record;
    }

}
