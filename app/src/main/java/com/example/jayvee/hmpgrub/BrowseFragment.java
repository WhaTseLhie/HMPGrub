package com.example.jayvee.hmpgrub;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BrowseFragment extends Fragment {

    ArrayList<Product> source = new ArrayList<>();
    ArrayList<Product> list = new ArrayList<>();
    ProductAdapter adapter;
    EditText txtSearch;
    ListView lv;
    Spinner cboFilter;
    String filter;

    public BrowseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_browse, container, false);

        getActivity().setTitle("Browse");

        source.add(new Product("1", "Piniritong Tae", "120", "Samsung"));
        source.add(new Product("2", "Lechong Tae", "500", "Apple"));
        source.add(new Product("3", "Tortang Tae", "50", "Microsoft"));
        source.add(new Product("4", "Adobong Tae", "80", "Google"));
        source.add(new Product("5", "Scrambled Tae", "20", "Mitsubishi"));
        source.add(new Product("6", "Tae Side Up", "20", "Pierce The Veil"));

        txtSearch = view.findViewById(R.id.editText);
        cboFilter = view.findViewById(R.id.spinner);
        lv = view.findViewById(R.id.listView);
        adapter = new ProductAdapter(getContext(), list);
        lv.setAdapter(adapter);

        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                list.clear();
                String search = charSequence.toString();
                Pattern pattern = Pattern.compile(search);
                Matcher m = pattern.matcher("Name");

                for(int index=0; index<source.size(); index++) {
                    switch(filter) {
                        case "Name": m = pattern.matcher(source.get(index).getProduct_name().toLowerCase()); break;
                        case "Price": m = pattern.matcher(source.get(index).getProduct_price().toLowerCase()); break;
                        case "Brand": m = pattern.matcher(source.get(index).getProduct_brand().toLowerCase());
                    }

                    if(m.find()) {
                        list.add(new Product(source.get(index).getProduct_id(), source.get(index).getProduct_name(), source.get(index).getProduct_price(), source.get(index).getProduct_brand()));
                    }
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        cboFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                filter = cboFilter.getItemAtPosition(i).toString();

                if(filter.equals("Price")) {
                    txtSearch.setInputType(InputType.TYPE_CLASS_NUMBER);
                } else {
                    txtSearch.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ProductProfile.class);
                intent.putExtra("product_name", list.get(i).product_name);
                intent.putExtra("product_price", list.get(i).product_price);
                intent.putExtra("product_brand", list.get(i).product_brand);
                startActivity(intent);
            }
        });

        return view;
    }
}
