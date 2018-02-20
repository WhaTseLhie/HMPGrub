package com.example.jayvee.hmpgrub;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ReviewsFragment extends Fragment {

    ListView lv;
    ArrayList<Reviews> list = new ArrayList<>();
    ReviewsAdapter adapter;

    public ReviewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reviews, container, false);

        getActivity().setTitle("Reviews");

        list.add(new Reviews("Jose Rizal", "Y cuando yami tumba de todos olvidada", "69"));
        list.add(new Reviews("Rodrigo Duterte", "My god! I hate drugs", "6"));

        lv = view.findViewById(R.id.listView);
        adapter = new ReviewsAdapter(getContext(), list);
        lv.setAdapter(adapter);

        return view;
    }

}
