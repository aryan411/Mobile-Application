package com.example.dixithihoriya_comp304sec001_lab1_ex2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

public class LifecycleFragment extends ListFragment {

    String[] activities = new String[]{"LifeCycle Activity","Profile Activity"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.lifecycle_fragment, container, false);
        //ArrayAdapter creates a view for each array item
        // by calling toString() on each item and placing
        // the contents in a TextView.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, activities);
        //bind the list view with array adapter
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onListItemClick(ListView lv, View v, int position, long id) {

        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(getContext(), LifecycleActivity.class);
                intent.putExtra("text", activities[0]);
                break;
            case 1:
                intent = new Intent(getContext(), ProfileActivity.class);
                intent.putExtra("text", activities[1]);
                break;
            default:
        }
        startActivity(intent);
    }
}