package com.example.krishnatejaare.schools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AsyncResponse {
    List<PlacesReadTask>schoolsamples=new ArrayList<>();
    List<ResultsReadTask>resultssamples=new ArrayList<>();
    private static final int ASYNC_ONE = 1;
    private static final int ASYNC_TWO = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button viewlist;
        viewlist = (Button) findViewById(R.id.viewlist);
        viewlist.setOnClickListener(this);


    }

    private void readcsvdata(){
        PlacesReadTask sample;
        InputStream is=getResources().openRawResource(R.raw.data);
        BufferedReader reader=new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String line;
        try{
            //step over headers
            reader.readLine();
            while((line=reader.readLine())!=null){
                 String[] tokens=line.split(",");
                 sample=new PlacesReadTask();
                if((tokens.length>0) &&(tokens[0].length()>0)){
                    sample.setId(tokens[0]);
                }
                else{
                    sample.setId("NDA");
                }
                if((tokens.length> 1) && (tokens[1].length() > 0)) {
                    sample.setSchool_name(tokens[1]);
                }
                else{
                    sample.setSchool_name("NDA");
                }
                 schoolsamples.add(sample);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(schoolsamples);
    }

    private void resultsreadcsvdata(){
        ResultsReadTask sample;
        InputStream is=getResources().openRawResource(R.raw.results);
        BufferedReader reader=new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String line;
        try{
            //step over headers
            reader.readLine();
            while((line=reader.readLine())!=null){
                String[] tokens=line.split(",");
                sample=new ResultsReadTask();
                if((tokens.length>0) &&(tokens[0].length()>0)){
                    sample.setId(tokens[0]);
                }
                else{
                    sample.setId("NDA");
                }

                if((tokens.length> 1) && (tokens[1].length() > 0)) {
                    sample.setSchool_name(tokens[1]);
                }
                else{
                    sample.setSchool_name("NDA");
                }

                if((tokens.length>2) &&(tokens[2].length()>0)){
                    sample.setTotal_students(tokens[2]);
                }
                else{
                    sample.setTotal_students("NDA");
                }
                if((tokens.length>3) &&(tokens[3].length()>0)){
                    sample.setReading(tokens[2]);
                }
                else{
                    sample.setReading("NDA");
                }
                if((tokens.length>4) &&(tokens[4].length()>0)){
                    sample.setMath(tokens[2]);
                }
                else{
                    sample.setMath("NDA");
                }
                if((tokens.length>5) &&(tokens[5].length()>0)){
                    sample.setWriting(tokens[2]);
                }
                else{
                    sample.setWriting("NDA");
                }
                resultssamples.add(sample);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(resultssamples);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.viewlist) {

            Intent i = new Intent(MainActivity.this, Main2Activity.class);
            Bundle args = new Bundle();
            args.putSerializable("myList", (Serializable) schoolsamples);
            args.putSerializable("myresults", (Serializable) resultssamples);
            i.putExtra("bundle", args);
            startActivity(i);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        readcsvdata();
        resultsreadcsvdata();
        url();
        url2();

    }

    private void url() {
        StringBuilder PlacesUrl = new StringBuilder("https://data.cityofnewyork.us/resource/97mf-9njv.json");
        ReadTask googlePlacesReadTask = new ReadTask();
        Object[] toPass = new Object[1];
        toPass[0] = PlacesUrl.toString();
        googlePlacesReadTask.execute(toPass);
    }


    @Override
    public void onProcessFinish(Object result, int id) {

        if(id == ASYNC_ONE){
            List<PlacesReadTask>res=(List<PlacesReadTask>) result;
            schoolsamples=res;
        }
        if(id == ASYNC_TWO){
            List<ResultsReadTask>res=(List<ResultsReadTask>) result;
            resultssamples=res;
        }

    }

    private void url2() {
        StringBuilder PlacesUrl = new StringBuilder("https://data.cityofnewyork.us/resource/734v-jeq5.json");
        DetailsReadTask googlePlacesReadTask = new DetailsReadTask();
        Object[] toPass = new Object[1];
        toPass[0] = PlacesUrl.toString();
        googlePlacesReadTask.execute(toPass);
    }





}
