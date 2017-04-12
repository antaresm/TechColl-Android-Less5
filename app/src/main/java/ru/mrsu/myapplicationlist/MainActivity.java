package ru.mrsu.myapplicationlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static java.lang.System.in;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<Student>();
        for (int i = 0; i < 10; i++){
            list.add(new Student("Иванов " + String.valueOf(i)));
        }

        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.rsclView);

        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;

//        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyRecycleAdapter(list);
        mRecyclerView.setAdapter(mAdapter);

        Button btnShow = (Button)findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TEST", "Btn click");
                showStudents();
            }
        });
    }

    private void showStudents() {
        Log.d("TEST", "SHOW");
        for (int i = 0; i < list.size(); i++){
            Student s = list.get(i);
            Log.d("TEST", s.name + " : " + (s.onLesson ? "+" : "-"));
        }
    }

}
