package com.example.jayvee.hmpgrub;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeTasteFragment extends Fragment {

    ListView lv;
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;

    public HomeTasteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_taste, container, false);

        list.add("Coq au vin");
        list.add("Cassoulet");
        list.add("Beef Bourguignon");
        list.add("Chocolate Souffle");
        list.add("Flamiche");
        list.add("Confit de Canard");
        list.add("Nicoise Salad");

        lv = view.findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

        return view;
    }

}
