package com.example.jayvee.hmpgrub;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoritesCravingFragment extends Fragment {

    ListView lv;
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;

    public FavoritesCravingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites_craving, container, false);

        list.add("Chao Fan");
        list.add("Kung Pao Chicken");
        list.add("Ma Po Tofu");
        list.add("Dumplings");
        list.add("Chow Mein");
        list.add("Fetus");

        lv = view.findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

        return view;
    }

}
