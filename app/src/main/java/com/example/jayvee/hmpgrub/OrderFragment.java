package com.example.jayvee.hmpgrub;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class OrderFragment extends Fragment {

    Button btnCheckOut;

    public OrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        getActivity().setTitle("Orders");

        btnCheckOut = view.findViewById(R.id.button);

        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Sorry for Inconvenience! Under Construction", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
