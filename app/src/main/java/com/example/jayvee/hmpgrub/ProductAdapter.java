package com.example.jayvee.hmpgrub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Product> list;
    private LayoutInflater inflater;

    public ProductAdapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ProductHandler handler;

        if(view == null) {
            handler = new ProductHandler();
            view = inflater.inflate(R.layout.adapter_product, null);

            handler.iv = view.findViewById(R.id.imageView);
            handler.txtName = view.findViewById(R.id.textView);
            handler.txtSeller = view.findViewById(R.id.textView1);
            handler.txtPrice = view.findViewById(R.id.textView2);

            view.setTag(handler);
        } else {
            handler = (ProductHandler) view.getTag();
        }

        handler.txtName.setText(list.get(i).getProduct_name());
        handler.txtSeller.setText(list.get(i).getProduct_brand());
        handler.txtPrice.setText(list.get(i).getProduct_price());

        return view;
    }

    static class ProductHandler {
        ImageView iv;
        TextView txtName, txtSeller, txtPrice;
    }
}