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


/**
 * A simple {@link Fragment} subclass.
 */
public class deleteContactFragment extends Fragment {
    private Button BnDel;
    private EditText conId;
    public deleteContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_contact, container, false);
        BnDel = view.findViewById(R.id.submit_delete);
        conId = view.findViewById(R.id.delete_contact_id);
        BnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });
        return view;
    }
    private void deleteContact()
    {
        int id = Integer.parseInt(conId.getText().toString());
        ContactdbHelper cd = new ContactdbHelper(getActivity());
        SQLiteDatabase db = cd.getWritableDatabase();
        cd.deleteContact(id,db);
        cd.close();
        Toast.makeText(getActivity(),"Deleted contact with Id"+id,Toast.LENGTH_SHORT).show();
        conId.setText("");
    }
}
