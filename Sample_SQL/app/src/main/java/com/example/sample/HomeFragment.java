package com.example.sample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements OnClickListener
    {
    private Button BnSave,BnView,BnDelete,BnUpdate;
    onDbOpListener dbOpListener;
    public HomeFragment() {
        // Required empty public constructor
    }

        @Override
        public void onClick(View v) {
            switch ((v.getId())){
                case R.id.add_contact:
                    dbOpListener.dbOpPerform(0);
                break;
                case R.id.view_contact:
                    dbOpListener.dbOpPerform(1);
                    break;
                case R.id.update_contact:
                    dbOpListener.dbOpPerform(2);
                    break;
                case R.id.delete_contact:
                    dbOpListener.dbOpPerform(3);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + (v.getId()));
            }
        }

        @Override
        public void onAttach(@NonNull Context context) {
            super.onAttach(context);
            Activity activity = (Activity)context;
            try{
            dbOpListener = (onDbOpListener) activity;
        }catch (ClassCastException e){
                throw new ClassCastException(activity.toString()+" must implement that interface method");
            }
    }

        public interface onDbOpListener{
        public void dbOpPerform(int method);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        BnSave =  view.findViewById(R.id.add_contact);
        BnSave.setOnClickListener(this);
        BnView = view.findViewById(R.id.view_contact);
        BnView.setOnClickListener(this);
        BnUpdate = view.findViewById(R.id.update_contact);
        BnUpdate.setOnClickListener(this);
        BnDelete = view.findViewById(R.id.delete_contact);
        BnDelete.setOnClickListener(this);
        return view;
    }

}
