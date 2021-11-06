package com.secure.isro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.secure.isro.R;
import com.secure.isro.models.SpacecraftsItem;

import java.util.List;

public class SpacecraftsAdapter extends RecyclerView.Adapter<SpacecraftsAdapter.ViewHolder> {

    List<SpacecraftsItem> spacecraftsList;

    public SpacecraftsAdapter(List<SpacecraftsItem> spacecraftsList){
        this.spacecraftsList = spacecraftsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spacecraft_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SpacecraftsItem item = spacecraftsList.get(position);
        holder.spacecrafts_item.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return spacecraftsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView spacecrafts_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            spacecrafts_item =itemView.findViewById(R.id.spacecrafts_item);
        }
    }
}
