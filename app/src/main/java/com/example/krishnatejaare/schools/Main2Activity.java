package com.example.krishnatejaare.schools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private List<PlacesReadTask> schoolsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SchoolsAdapter mAdapter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        ArrayList<PlacesReadTask> records = (ArrayList<PlacesReadTask>) args.getSerializable("myList");
        ArrayList<ResultsReadTask>results=(ArrayList<ResultsReadTask>)args.getSerializable("myresults");
        System.out.println("size is"+records.size());

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new SchoolsAdapter(records,results,this);
        System.out.println(mAdapter.getItemCount());
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        System.out.println("END OF THE RECYCLER VIEW");
    }
}
