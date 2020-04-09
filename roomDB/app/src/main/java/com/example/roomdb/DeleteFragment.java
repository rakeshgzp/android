package com.example.roomdb;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteFragment extends Fragment {
    private EditText id;
    private Button submit;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        id = view.findViewById(R.id.delete_contact_id);
        submit = view.findViewById(R.id.submit_delete);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Id = Integer.parseInt(id.getText().toString());
                User user = new User();
                user.setId(Id);
                MainActivity.myAppDatabase.myDao().deleteUser(user);
                id.setText("");
                Toast.makeText(getActivity(),"Id deleted Succesfully",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
