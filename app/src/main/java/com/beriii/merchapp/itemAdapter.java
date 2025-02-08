package com.beriii.merchapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemViewerHolder> {

    Context context;
    List<item> itemList;

    public itemAdapter(Context context, List<item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public itemViewerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new itemViewerHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewerHolder holder, int position) {
        holder.itemName.setText(itemList.get(position).getName());
        holder.itemPrice.setText("$ ".concat(String.valueOf(itemList.get(position).getPrice())));
        holder.item_image.setImageResource(itemList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
