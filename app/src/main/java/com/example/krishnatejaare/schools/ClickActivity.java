package com.example.krishnatejaare.schools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ClickActivity extends AppCompatActivity {

    public TextView school,testtakers,readingscore,mathscore,writingscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        ResultsReadTask records = (ResultsReadTask) args.getSerializable("myobject");
        school=(TextView)findViewById(R.id.school);
        testtakers=(TextView)findViewById(R.id.testtakers);
        readingscore=(TextView)findViewById(R.id.readingscore);
        mathscore=(TextView)findViewById(R.id.mathscore);
        writingscore=(TextView)findViewById(R.id.writingscore);
        school.setText(records.getSchool_name());
        testtakers.setText(records.getTotal_students());
        readingscore.setText(records.getReading());
        mathscore.setText(records.getMath());
        writingscore.setText(records.getWriting());
    }
}
