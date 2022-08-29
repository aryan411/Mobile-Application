package com.example.dixithihoriya_aryanpatel_comp304sec001_lab05;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private Activity sContext;
    List<Students> studentsList;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = sContext.getLayoutInflater();
        View studentListView = inflater.inflate(R.layout.list_item, null, true);

        TextView stname = studentListView.findViewById(R.id.stname);
        TextView stid = studentListView.findViewById(R.id.stid);

        Students students = studentsList.get(position);
        stname.setText(students.getName());
        stid.setText(students.getId());
        return studentListView;
    }

    public ListAdapter(Activity sContext, List<Students> studentsList) {
        super(sContext, R.layout.list_item, studentsList);
        this.sContext = sContext;
        this.studentsList = studentsList;
    }
}
