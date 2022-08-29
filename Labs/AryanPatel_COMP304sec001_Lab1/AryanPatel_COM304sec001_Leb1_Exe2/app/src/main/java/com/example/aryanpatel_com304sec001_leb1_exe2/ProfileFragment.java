package com.example.aryanpatel_com304sec001_leb1_exe2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    TextView textViewName,textViewQualification,textViewJob,textViewHobby;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        textViewName= (TextView) view.findViewById(R.id.profile_name);
        textViewJob= (TextView)view.findViewById(R.id.profile_dreamjob);
        textViewHobby= (TextView)view.findViewById(R.id.profile_hobby);
        textViewQualification= (TextView)view.findViewById(R.id.profile_qualification);

        return view;
    }

    public void display(String name, String job, String hobby, String qualification){
        textViewName.setText(name);
        textViewJob.setText(job);
        textViewHobby.setText(hobby);
        textViewQualification.setText(qualification);

    }
}