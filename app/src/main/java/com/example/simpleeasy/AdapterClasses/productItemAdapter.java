package com.example.simpleeasy.AdapterClasses;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.simpleeasy.DetailProductActivity2;
import com.example.simpleeasy.ModelClass.ProductItem;
import com.example.simpleeasy.ProductCategory;
import com.example.simpleeasy.R;

import java.util.ArrayList;
import java.util.List;

public class productItemAdapter extends RecyclerView.Adapter<productItemAdapter.CustomHolderClass> {
    private List<ProductItem> productItems = new ArrayList<>();
    Context context;
    ViewPager2 viewPager2;
    PositionListener positionListener;

    public interface PositionListener {
        int getPosition(int position);
    }

    public void setPosition(PositionListener position) {
        this.positionListener = position;
    }

    public productItemAdapter(List<ProductItem> productItems, Context context) {
        this.productItems = productItems;
        this.context = context;
    }

    public productItemAdapter(List<ProductItem> productItems) {
        this.productItems = productItems;
    }

    @NonNull
    @Override
    public CustomHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (context != null) {
            view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.produc_items_layout, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.product_item_layout_viewpager, parent, false);
        }
        return new CustomHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolderClass holder, int position) {
        ProductItem productItem = productItems.get(position);
        /*if (position >= productItems.size() - 3) {
            productItems.addAll(productItems);
        }*/
        holder.setViewsAdapter(productItem);
        holder.textView.setText(position + " " + productItems.size());
        holder.imageView.setImageResource(productItems.get(position).getImages());
        positionListener.getPosition(position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailProductActivity2.class);
                intent.putExtra("Image_Path", productItem.getImages());
                intent.putExtra("name", productItem.getName());
                intent.putExtra("price", productItem.getPrice());
                intent.putExtra("quantity", productItem.getQuantity());
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(holder.imageView, "image");
                //pairs[1]= new Pair<View,String>(holder.button,"image");
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                context.startActivity(intent , activityOptions.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return productItems.size();
    }

    public class CustomHolderClass extends RecyclerView.ViewHolder {
        TextView textView, textView2, textView3;
        ImageView imageView;
        LinearLayout linearLayout;
        CardView cardView;
        Button button;

        CustomHolderClass(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.product_item_data);
            textView2 = (TextView) itemView.findViewById(R.id.product_item_price1);
            textView3 = (TextView) itemView.findViewById(R.id.product_item_size1);
            imageView = (ImageView) itemView.findViewById(R.id.product_item_images);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.product_item_root_layout);
            cardView = (CardView) itemView.findViewById(R.id.product_item_cardview);
            button = (Button) itemView.findViewById(R.id.add_to_cart_item);
        }

        void setViewsAdapter(ProductItem item) {
            imageView.setImageResource(item.getImages());
            textView.setText(item.getName());
             /*textView2.setText("$ "+item.getPrice());
             textView3.setText(item.getQuantity());*/


        }
    }
}