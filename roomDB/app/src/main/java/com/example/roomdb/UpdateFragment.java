package com.example.roomdb;

import android.Manifest;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.xml.namespace.QName;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {
    private EditText name,id,email;
    private Button submit;
    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        submit = view.findViewById(R.id.submit_update);
        name = view.findViewById(R.id.update_name);
        id = view.findViewById(R.id.update_contact_id);
        email = view.findViewById(R.id.update_email);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                int user_id = Integer.parseInt(id.getText().toString());
                String user_name = name.getText().toString();
                String user_email = email.getText().toString();
                user.setId(user_id);
                user.setName(user_name);
                user.setEmail(user_email);
                MainActivity.myAppDatabase.myDao().updateUser(user);
                Toast.makeText(getActivity(),"Id updated",Toast.LENGTH_SHORT).show();
                id.setText("");
                email.setText("");
                name.setText("");
            }
        });
        return view;
    }
}
