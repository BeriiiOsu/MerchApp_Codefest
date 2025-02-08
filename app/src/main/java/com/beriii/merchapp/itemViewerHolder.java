package com.beriii.merchapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class itemViewerHolder extends RecyclerView.ViewHolder {

    ImageView item_image;
    TextView itemName, itemPrice;
    RelativeLayout buyBtn, addCart;

    public itemViewerHolder(@NonNull View itemView) {
        super(itemView);

        item_image = itemView.findViewById(R.id.item_image);
        itemName = itemView.findViewById(R.id.itemName);
        itemPrice = itemView.findViewById(R.id.itemPrice);
        buyBtn = itemView.findViewById(R.id.buyBtn);
        addCart = itemView.findViewById(R.id.addCart);

    }
}
