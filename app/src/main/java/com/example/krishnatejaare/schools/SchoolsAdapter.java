package com.example.krishnatejaare.schools;

import android.content.Context;
import android.content.Intent;
import android.icu.text.AlphabeticIndex;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krishna Teja Are on 4/11/2018.
 */



public class SchoolsAdapter extends RecyclerView.Adapter<SchoolsAdapter.MyViewHolder> {

    private List<PlacesReadTask> schoolsList;
    private List<ResultsReadTask> resultsList;
    Context ctx;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, vicinity,rating;
        Context ctx;

        public MyViewHolder(View view, Context ctx) {

            super(view);
            this.ctx=ctx;
            view.setOnClickListener(this);
            title = (TextView) view.findViewById(R.id.title);

        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            ResultsReadTask object=new ResultsReadTask();
            PlacesReadTask P = schoolsList.get(position);
            String id= P.getId();
            for(int i=0;i<resultsList.size();i++){
                ResultsReadTask r=resultsList.get(i);
                if(r.getId()==id){
                    object=r;
                }

            }
            Intent i = new Intent(ctx, ClickActivity.class);
            Bundle args = new Bundle();
            args.putSerializable("myobject", (Serializable) object);
            i.putExtra("bundle", args);
            ctx.startActivity(i);


        }
    }


    public SchoolsAdapter(List<PlacesReadTask> schoolsList, List<ResultsReadTask>resultsList,Context ctx) {
        this.schoolsList = schoolsList;
        this.resultsList=resultsList;
        this.ctx=ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schools, parent, false);

        return new MyViewHolder(itemView,ctx);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PlacesReadTask movie = schoolsList.get(position);
        holder.title.setText(String.valueOf(movie.getSchool_name()));

    }

    @Override
    public int getItemCount() {
        System.out.println("In the schools adapter" + schoolsList.size());
        return this.schoolsList.size();
    }


}
