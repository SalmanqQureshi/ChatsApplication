package com.example.simpleeasy;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.CustomHolderClass> {
    List<ProductCategory> productCategories=new ArrayList<>();
    Context context;

    public ProductAdapter(List<ProductCategory> productCategories, Context context) {
        this.productCategories = productCategories;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item_layout, parent, false);
        return new CustomHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolderClass holder, int position) {
        holder.textView.setText(productCategories.get(position).getProductName());
    }

    @Override
    public int getItemCount() {
        return productCategories.size();
    }

    public class CustomHolderClass extends RecyclerView.ViewHolder {
        TextView textView;
        public CustomHolderClass(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textChipdata);
        }
    }
}
