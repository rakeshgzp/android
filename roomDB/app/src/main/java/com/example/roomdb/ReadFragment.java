package com.example.roomdb;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadFragment extends Fragment {
    private TextView readText;
    public ReadFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_read, container, false);
        readText = view.findViewById(R.id.txt_display);
        List<User> users = MainActivity.myAppDatabase.myDao().getUsers();
        String info = "";
        for(User user:users){
            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();
            info += "\n\n"+"Id: "+id+"\n Name: "+name+"\n Email: "+email;
        }
        readText.setText(info);
        return  view;
    }
}
