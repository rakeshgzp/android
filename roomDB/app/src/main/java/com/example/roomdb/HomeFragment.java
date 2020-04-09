package com.example.roomdb;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{
    private Button addUser,updateUser,readUser,deleteUser;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        addUser = view.findViewById(R.id.add_contact);
        addUser.setOnClickListener(this);
        readUser = view.findViewById(R.id.view_contact);
        readUser.setOnClickListener(this);
        deleteUser = view.findViewById(R.id.delete_contact);
        deleteUser.setOnClickListener(this);
        updateUser = view.findViewById(R.id.update_contact);
        updateUser.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_contact:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new AddUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.view_contact:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ReadFragment()).addToBackStack(null).commit();
                break;
            case R.id.delete_contact:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteFragment()).addToBackStack(null).commit();
                break;
            case R.id.update_contact:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateFragment()).addToBackStack(null).commit();
                break;
        }

    }
}
