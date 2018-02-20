package com.example.jayvee.hmpgrub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReviewsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Reviews> list;
    private LayoutInflater inflater;

    public ReviewsAdapter(Context context, ArrayList<Reviews> list) {
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
        ReviewHandler handler;

        if(view == null) {
            handler = new ReviewHandler();
            view = inflater.inflate(R.layout.adapter_reviews, null);

            handler.iv = view.findViewById(R.id.imageView);
            handler.txtName = view.findViewById(R.id.textView);
            handler.txtWritten = view.findViewById(R.id.textView1);
            handler.txtRating = view.findViewById(R.id.textView2);

            view.setTag(handler);
        } else {
            handler = (ReviewHandler) view.getTag();
        }

        handler.txtName.setText(list.get(i).getReview_name());
        handler.txtWritten.setText(list.get(i).getReview_written());
        handler.txtRating.setText(list.get(i).getReview_rating());

        return view;
    }

    static class ReviewHandler {
        ImageView iv;
        TextView txtName, txtWritten, txtRating;
    }
}