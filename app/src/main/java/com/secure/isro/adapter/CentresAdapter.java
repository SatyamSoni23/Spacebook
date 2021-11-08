package com.secure.isro.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.secure.isro.R;
import com.secure.isro.databinding.CentresItemsBinding;
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
        CentresItemsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.centres_items, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CentresItem centresItem = centresItemList.get(position);
        holder.centres_item_binding.centresItemName.setText(centresItem.getName());
        holder.centres_item_binding.centresItemPlace.setText(centresItem.getPlace());
        holder.centres_item_binding.centresItemState.setText(centresItem.getState());
    }

    @Override
    public int getItemCount() {
        return centresItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CentresItemsBinding centres_item_binding;
        public ViewHolder(@NonNull CentresItemsBinding binding) {
            super(binding.getRoot());
            centres_item_binding = binding;
        }
    }
}
