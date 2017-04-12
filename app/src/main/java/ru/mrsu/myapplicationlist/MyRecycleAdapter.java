package ru.mrsu.myapplicationlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolder> {
    private ArrayList<Student> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public Student s;
        Switch sw;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView)v.findViewById(R.id.textView2);
            sw = (Switch)v.findViewById(R.id.switch1);
            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    onSwitch(b);
                }
            });
        }

        private void onSwitch(boolean b) {
            if (this.s != null) {
                this.s.onLesson = b;
            }
        }
    }

    public MyRecycleAdapter(ArrayList<Student> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public MyRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Student s = (Student)mDataset.get(position);
        holder.s = s;
        holder.mTextView.setText(s.name);
        holder.sw.setChecked(s.onLesson);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
