package com.example.a15017206.exercise2_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by 15017206 on 11/05/2017.
 */

public class TaskAdapter extends ArrayAdapter<Task>{

    private ArrayList<Task> task;
    private Context context;
    private TextView tvSomeText;

    public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        task = objects;
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.rowlistview, parent, false);

        // Get the TextView object - in row.xml
        tvSomeText = (TextView) rowView.findViewById(R.id.tvSomeText);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Task currentTask = task.get(position);
        // Set the TextView to show the food

//        tvFoodName.setText(currentFood.getName());
//        // Set the image to star or nostar accordingly
//        if (currentFood.isStar()) {
//            ivStar.setImageResource(R.drawable.star);
//
//
//        } else {
//            ivStar.setImageResource(R.drawable.nostar);
//        }

        tvSomeText.setText("ID: " + currentTask.getId() + "Desc: " + currentTask.getDescription() + "Date: " + currentTask.getDate());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
