package com.example.simpleeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.simpleeasy.AdapterClasses.productItemAdapter;
import com.example.simpleeasy.ModelClass.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class OnlineCosmaticActivity extends AppCompatActivity implements productItemAdapter.PositionListener {

    RecyclerView chipButtonrecyclerView, productItemrecyclerView;
    List<ProductCategory> productCategories = new ArrayList<>();
    List<ProductItem> productItems = new ArrayList<>();
    ProductAdapter productAdapter;
    productItemAdapter productItemAdapter;
    int countListItemAnInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_cosmatic);

        RecylerInitilie();
        RecylerProductItemsInitilie();

        chipButtonrecyclerView = findViewById(R.id.chipbutton_product_recylerview);
        productItemrecyclerView = findViewById(R.id.product_Item_recylerview);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        chipButtonrecyclerView.setLayoutManager(layoutManager);
        productItemrecyclerView.setLayoutManager(layoutManager2);
        productAdapter = new ProductAdapter(productCategories, OnlineCosmaticActivity.this);
        productItemAdapter = new productItemAdapter(productItems, OnlineCosmaticActivity.this);

        productItemrecyclerView.setAdapter(productItemAdapter);
        chipButtonrecyclerView.setAdapter(productAdapter);
        productItemAdapter.setPosition(this);
//        productItemrecyclerView.notifyAll();
        productItemrecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.d("Tag", "onScrollChangeListener: "+countListItemAnInt);
                productItemAdapter.notifyDataSetChanged();
            }

        });

        /*productItemrecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d("Tag", "onScrollListener: " + " New State" + newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.d("Tag", "onScrollListener: " + dx + " " + dy);
            }

        });*/
    }

    void RecylerInitilie() {
        productCategories.add(new ProductCategory(1, "Make Up"));
        productCategories.add(new ProductCategory(2, "Perfume"));
        productCategories.add(new ProductCategory(3, "Lipstike"));
        productCategories.add(new ProductCategory(4, "Bleach Cream"));
        productCategories.add(new ProductCategory(5, "Face Wash"));
        productCategories.add(new ProductCategory(6, "Fair & Lovely"));
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
        //Log.d("Get POsition through both interface and adpater class ", "getPosition: " + position);
        countListItemAnInt=position;
        return countListItemAnInt;
    }
}