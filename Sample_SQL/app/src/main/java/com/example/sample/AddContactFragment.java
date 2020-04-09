package com.example.sample;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddContactFragment extends Fragment {
    private Button bnSave;
    EditText Id,Name,Email;
    public AddContactFragment() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);
        // Inflate the layout for this fragment
        bnSave = view.findViewById(R.id.submit_add);
        Id = view.findViewById(R.id.txt_contact_id);
        Name = view.findViewById(R.id.txt_name);
        Email = view.findViewById(R.id.txt_email);
        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = Id.getText().toString();
                String name = Name.getText().toString();
                String email = Email.getText().toString();


                ContactdbHelper contactdbHelper = new ContactdbHelper(getActivity());
                SQLiteDatabase database = contactdbHelper.getWritableDatabase();
                contactdbHelper.addContact(Integer.parseInt(id), name, email,database);
                contactdbHelper.close();
                Id.setText("");
                Name.setText("");
                Email.setText("");
                Toast.makeText(getActivity(),"Contact saved Succesfully ...",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
