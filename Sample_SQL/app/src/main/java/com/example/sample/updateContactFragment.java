package com.example.sample;

import android.database.sqlite.SQLiteDatabase;
import android.media.browse.MediaBrowser;
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
public class updateContactFragment extends Fragment {
    private Button BnUpdate;
    private EditText BnId,BnName,BnEmail;
    public updateContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_contact, container, false);
        BnUpdate = view.findViewById(R.id.submit_update);
        BnId = view.findViewById(R.id.update_contact_id);
        BnName = view.findViewById(R.id.update_name);
        BnEmail = view.findViewById(R.id.update_email);
        BnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateContact();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    private void UpdateContact(){
        int id = Integer.parseInt(BnId.getText().toString());
        String name = BnName.getText().toString();
        String email = BnEmail.getText().toString();
        ContactdbHelper contactdbHelper = new ContactdbHelper(getActivity());
        SQLiteDatabase db = contactdbHelper.getWritableDatabase();
        contactdbHelper.updateContact(id,name,email,db);
        contactdbHelper.close();
        Toast.makeText(getActivity(),"Contact Updated",Toast.LENGTH_SHORT).show();
        BnId.setText("");
        BnName.setText("");
        BnEmail.setText("");
    }
}
