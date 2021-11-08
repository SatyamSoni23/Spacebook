package com.secure.isro.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.secure.isro.R;
import com.secure.isro.databinding.SpacecraftItemBinding;
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
        SpacecraftItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.spacecraft_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SpacecraftsItem item = spacecraftsList.get(position);
        holder.spacecrafts_item_binding.spacecraftsItem.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return spacecraftsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SpacecraftItemBinding spacecrafts_item_binding;
        public ViewHolder(@NonNull SpacecraftItemBinding binding) {
            super(binding.getRoot());
            spacecrafts_item_binding = binding;
        }
    }
}
