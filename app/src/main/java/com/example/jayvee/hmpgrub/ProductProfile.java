package com.example.jayvee.hmpgrub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProductProfile extends AppCompatActivity {

    Toolbar toolbar;
    ImageView imgProduct;
    TextView txtName, txtSeller, txtPrice;
    RatingBar ratingBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_product_profile);

        this.toolbar = this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        this.imgProduct = this.findViewById(R.id.imageView);
        this.txtName = this.findViewById(R.id.textView);
        this.txtSeller = this.findViewById(R.id.textView1);
        this.txtPrice = this.findViewById(R.id.textView2);
        this.ratingBar = this.findViewById(R.id.ratingBar);

        if(savedInstanceState == null) {
            Bundle b = getIntent().getExtras();

            if(b != null) {
                this.txtName.setText(b.getString("product_name"));
                this.txtPrice.setText(b.getString("product_price"));
                this.txtSeller.setText(b.getString("product_brand"));
            }
        } else {
            this.txtName.setText((String) savedInstanceState.getSerializable("product_name"));
            this.txtPrice.setText((String) savedInstanceState.getSerializable("product_price"));
            this.txtSeller.setText((String) savedInstanceState.getSerializable("product_brand"));
        }
    }
}
