package com.example.a15017206.exercise2_database;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //PLEASE USE EMULATOR <= API 23 AS BUGS ARE REPORTED IN HIGHER API LEVEL
    DBHelper db = new DBHelper(this);
    Button btnInsert, btnGetTasks;
    TextView tvResults;
    ArrayList<Task> task = new ArrayList<Task>();
    ListView lvTasks;
    TaskAdapter caTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnGetTasks = (Button) findViewById(R.id.btnGetTasks);
        tvResults = (TextView) findViewById(R.id.tvResults);
        lvTasks = (ListView) findViewById(R.id.lv);
        caTask = new TaskAdapter(this, R.layout.rowlistview, task);
        lvTasks.setAdapter(caTask);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();
            }
        }); // end of onClickListener

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Get Tasks from db and put into arraylist
                ArrayList<String> data = db.getTaskContent();
                ArrayList<Task> dataTask = db.getTasks();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i + ". " + data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                    task.add(new Task(dataTask.get(i).getId(), dataTask.get(i).getDescription(), dataTask.get(i).getDate()));
                }
                tvResults.setText(txt);
                caTask.notifyDataSetChanged();
            }
        });
    } // end of onCreate()
}

