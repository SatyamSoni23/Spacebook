package com.secure.isro.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.secure.isro.R;
import com.secure.isro.models.CentresItem;

import java.util.List;

public class CentresAdapter extends RecyclerView.Adapter<CentresAdapter.ViewHolder> {

    List<CentresItem> centresItemList;

    public CentresAdapter(List<CentresItem> centresItemList){
        this.centresItemList = centresItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.centres_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CentresItem centresItem = centresItemList.get(position);
        holder.centres_item_name.setText(centresItem.getName());
        holder.centres_item_place.setText(centresItem.getPlace());
        holder.centres_item_state.setText(centresItem.getState());
    }

    @Override
    public int getItemCount() {
        return centresItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView centres_item_name, centres_item_place, centres_item_state;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            centres_item_name = itemView.findViewById(R.id.centres_item_name);
            centres_item_place = itemView.findViewById(R.id.centres_item_place);
            centres_item_state = itemView.findViewById(R.id.centres_item_state);
        }
    }
}
