package com.example.simpleeasy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class DetailProductActivity2 extends AppCompatActivity {

    ImageView imageView,imageView_transition;
    TextView textDetailData, textDetailPrice, textDetailQnty;
    NestedScrollView nestedScrollView;
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    AppBarLayout appBarLayout;
    Button detail_product_addtocart;
    @RequiresApi(api = 31)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product2);
        imageView = findViewById(R.id.product_item_images);
        imageView_transition = findViewById(R.id.image_transaction);
        textDetailData = findViewById(R.id.product_item_detail_data);
        textDetailPrice = findViewById(R.id.product_item_detail_price1);
        textDetailQnty = findViewById(R.id.product_item_detail_size1);
        nestedScrollView = findViewById(R.id.nestedS);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        collapsingToolbarLayout = findViewById(R.id.collaps_toolbar);
        appBarLayout = findViewById(R.id.appBarLayout1);
        detail_product_addtocart=findViewById(R.id.detail_product_addtocart);
        int i = getIntent().getIntExtra("Image_Path", 0);
        String name = getIntent().getStringExtra("name");
        int price = getIntent().getIntExtra("price", 0);
        String quantity = getIntent().getStringExtra("quantity");
        imageView = findViewById(R.id.product_item_images);
        imageView.setImageResource(i);
        textDetailPrice.setText("$ " + price);
        textDetailQnty.setText(quantity);
        textDetailData.setText(name);
        detail_product_addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailProductActivity2.this, "Yes Its Click", Toast.LENGTH_SHORT).show();
            }
        });
//        Pair[] pairs = new Pair[1];
//        pairs[0] = new Pair<View, String>(holder.linearLayout, "image");
//        //pairs[1]= new Pair<View,String>(holder.button,"image");
//        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);




    }
}