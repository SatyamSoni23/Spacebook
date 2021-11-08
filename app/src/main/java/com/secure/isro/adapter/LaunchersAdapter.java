package com.secure.isro.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.secure.isro.R;
import com.secure.isro.databinding.LaunchersItemBinding;
import com.secure.isro.models.LaunchersItem;

import java.util.List;

public class LaunchersAdapter extends RecyclerView.Adapter<LaunchersAdapter.ViewHolder> {

    List<LaunchersItem> launchersItemList;

    public LaunchersAdapter(List<LaunchersItem> launchersItemList){
        this.launchersItemList = launchersItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LaunchersItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.launchers_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LaunchersItem launchersItem = launchersItemList.get(position);
        holder.launchers_item_binding.launchersItem.setText(launchersItem.getId());
    }

    @Override
    public int getItemCount() {
        return launchersItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LaunchersItemBinding launchers_item_binding;
        public ViewHolder(@NonNull LaunchersItemBinding binding) {
            super(binding.getRoot());
            launchers_item_binding = binding;
        }
    }
}
