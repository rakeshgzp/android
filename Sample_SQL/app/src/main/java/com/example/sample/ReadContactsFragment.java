package com.example.sample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadContactsFragment extends Fragment {
    private TextView txt_Display;
    public ReadContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_contacts, container, false);
        txt_Display = view.findViewById(R.id.txt_display);
        readContact();
        return view;
    }
    private void readContact(){
        ContactdbHelper contactdbHelper = new ContactdbHelper(getActivity());
        SQLiteDatabase db = contactdbHelper.getReadableDatabase();
        Cursor cursor = contactdbHelper.readContacts(db);
        String info="";
        while(cursor.moveToNext()){
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            String name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            String email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
            info = info +"\n\n"+"Id: "+id+"\n Name:"+name+"\n Email:"+email;
        }
        txt_Display.setText(info);
        contactdbHelper.close();
    }
}
