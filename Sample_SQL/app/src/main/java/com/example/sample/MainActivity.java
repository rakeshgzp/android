package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements HomeFragment.onDbOpListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }
            HomeFragment hf = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,hf).commit();
        }
    }


    @Override
    public void dbOpPerform(int method) {
        switch(method){
            case 0:
                Log.d("Load Fragment","AddContact Fragment Loaded");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddContactFragment()).addToBackStack(null).commit();
                break;
            case 1:
                Log.d("Load Fragment","ViewContact Fragment Added");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ReadContactsFragment()).addToBackStack(null).commit();
                break;
            case 2:
                Log.d("Load Fragment","UpdateContact Fragment Added");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new updateContactFragment()).addToBackStack(null).commit();
                break;
            case 3:
                Log.d("Load Fragment","DeleteContact Fragment Added");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new deleteContactFragment()).addToBackStack(null).commit();
                break;

        }

    }
}
