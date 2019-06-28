package com.example.week2day3zoorecyclerandlistviews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalsPerCategoryAdapter extends RecyclerView.Adapter<AnimalsPerCategoryAdapter.ViewHolder> {

    ArrayList<Animal> animalsArrayList;
    Context context;

    public AnimalsPerCategoryAdapter(ArrayList<Animal> animalsArrayList, Context context) {
        this.animalsArrayList = animalsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.animals_per_category, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Animal currentAnimalBeingRendered = animalsArrayList.get(position);
        holder.tvName.setText(currentAnimalBeingRendered.getName());
        holder.tvCategory.setText(currentAnimalBeingRendered.getCategory());
        holder.tvDescription.setText(currentAnimalBeingRendered.getDescription());
        holder.tvSound.setText(currentAnimalBeingRendered.getSound());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anIntent = new Intent(context, AnimalDetails.class);
                Bundle newBundle = new Bundle();
                newBundle.putParcelable("animal", currentAnimalBeingRendered);
                anIntent.putExtras(newBundle);
                context.startActivity(anIntent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return animalsArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvCategory;
        TextView tvDescription;
        TextView tvSound;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvSound = itemView.findViewById(R.id.tvSound);
        }
    }

}
