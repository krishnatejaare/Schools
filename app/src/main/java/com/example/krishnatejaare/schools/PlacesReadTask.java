package com.example.krishnatejaare.schools;

import android.widget.Toast;

import java.io.File;
import java.io.FileReader;

/**
 * Created by Krishna Teja Are on 4/11/2018.
 */

public class PlacesReadTask {
    private String school_name;
    private String id;


    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    @Override
    public String toString() {
        return "PlacesReadTask{" +
                "school_name='" + school_name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
