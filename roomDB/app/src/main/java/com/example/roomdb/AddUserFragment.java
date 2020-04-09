package com.example.roomdb;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
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
public class AddUserFragment extends Fragment {
    private Button btnSubmit;
    private EditText id,name,email;
    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_user, container, false);
        id = view.findViewById(R.id.txt_contact_id);
        name = view.findViewById(R.id.txt_name);
        email = view.findViewById(R.id.txt_email);
        btnSubmit = view.findViewById(R.id.submit_add);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userid = Integer.parseInt(id.getText().toString());
                String UserName = name.getText().toString();
                String Useremail = email.getText().toString();
                User user = new User();
                user.setId(userid);
                user.setName(UserName);
                user.setEmail(Useremail);
                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(),"1 User added",Toast.LENGTH_SHORT).show();
                id.setText("");
                name.setText("");
                email.setText("");
            }
        });
        return view;
    }
}
