package com.secure.isro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.secure.isro.R;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.launchers_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LaunchersItem launchersItem = launchersItemList.get(position);
        holder.launchers_item.setText(launchersItem.getId());
    }

    @Override
    public int getItemCount() {
        return launchersItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        MaterialTextView launchers_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            launchers_item = itemView.findViewById(R.id.launchers_item);
        }
    }
}
