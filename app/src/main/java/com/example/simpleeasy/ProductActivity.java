package com.example.simpleeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.simpleeasy.AdapterClasses.productItemAdapter;
import com.example.simpleeasy.ModelClass.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity implements productItemAdapter.PositionListener {

    ViewPager2 viewPager2;
    List<ProductItem> productItems = new ArrayList<>();
    productItemAdapter productItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        RecylerProductItemsInitilie();
        viewPager2 = findViewById(R.id.animated_VP);
        //productItemAdapter =
        productItemAdapter = new productItemAdapter(productItems);
        viewPager2.setAdapter(productItemAdapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        productItemAdapter.setPosition(this);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
                productItemAdapter.notifyDataSetChanged();
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
    }

    void RecylerProductItemsInitilie() {
        productItems.add(new ProductItem(1, "Gulabi cheez pta nhi kia ha ye.", R.drawable.gulabicheez, 93, "150 ml"));
        productItems.add(new ProductItem(2, "shampoo signal wala.", R.drawable.shampoo, 33, "120 ml"));
        productItems.add(new ProductItem(3, "MakeUp ka pura set without discount k sat.", R.drawable.perfume, 99, "160 ml"));
        productItems.add(new ProductItem(4, "Pencil wali lisptike achi ha.", R.drawable.makeup, 100, "200 ml"));
        productItems.add(new ProductItem(5, "Gulabi cheez pta nhi kia ha ye.", R.drawable.fragrance2, 48, "70 ml"));
        productItems.add(new ProductItem(6, "Make Up signal wala.", R.drawable.facecream, 120, "200 ml"));
        productItems.add(new ProductItem(7, "MakeUp ka pura set without discount k sat.", R.drawable.makeupset3, 48, "180 ml"));
        productItems.add(new ProductItem(8, "Pencil wali lisptike achi ha.", R.drawable.pencilwali, 100, "190 ml"));
        productItems.add(new ProductItem(9, "face Skin cream.", R.drawable.babyskin, 24, "85 ml"));
    }

    @Override
    public int getPosition(int position) {
        return position;
    }
}