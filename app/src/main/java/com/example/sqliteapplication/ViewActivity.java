package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    RecyclerView studentRecycler;
    TextView heading;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        heading = findViewById(R.id.view_data_heading);

        ArrayList<Model> studentsList = getStudentList();

        if(studentsList.size() == 0)
            heading.setText("No data!");
        else{
            // Recycler view
            studentRecycler = findViewById(R.id.student_recycler);
            Adapter adapter = new Adapter(this, studentsList);
            studentRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            studentRecycler.setAdapter(adapter);
        }

    }

    public ArrayList<Model> getStudentList(){

        Cursor res = new DBHelper(this).getdata();
        ArrayList<Model> studentsList = new ArrayList<>();

        while(res.moveToNext()){
            Model student = new Model();
            student.setName(res.getString(0));
            student.setAddress(res.getString(1));
            student.setDob(res.getString(2));
            studentsList.add(student);
        }
        return studentsList;
    }

}