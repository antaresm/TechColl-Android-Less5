package ru.mrsu.myapplicationlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;


public class MyAdapter extends BaseAdapter {

    Context c;
    ArrayList<Student> list;

    public MyAdapter(Context ctx, ArrayList<Student> list){
        super();
        this.c = ctx;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) c
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v = inflater.inflate(R.layout.item_layout, viewGroup, false);
        }

        Student s = list.get(i);

        TextView tv = (TextView)v.findViewById(R.id.textView2);
        tv.setText(s.name);

        Switch sw = (Switch)v.findViewById(R.id.switch1);
        sw.setTag(String.valueOf(i));
        sw.setChecked(s.onLesson);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String s = (String)compoundButton.getTag();
                onSwitch(s, b);
            }
        });

        return v;
    }

    private void onSwitch(String s, boolean b) {
        int i = Integer.valueOf(s);
        Student st = (Student)getItem(i);
        st.onLesson = b;
    }
}
