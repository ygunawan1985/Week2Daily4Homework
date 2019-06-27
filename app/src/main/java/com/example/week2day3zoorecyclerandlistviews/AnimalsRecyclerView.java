package com.example.week2day3zoorecyclerandlistviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class AnimalsRecyclerView extends AppCompatActivity {

    RecyclerView rvRecyclerView;
    ArrayList<Animal> animals;
    ArrayList<Animal> resultAnimals;
    String categoryValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_recycler_view);

        rvRecyclerView =findViewById(R.id.rvRecyclerView);
        Intent receivedIntent = getIntent();
        Bundle receivedBundle = receivedIntent.getExtras();
        if(receivedBundle != null) {
            categoryValue = receivedBundle.getString("categoryValue");
            animals = receivedBundle.getParcelableArrayList("animals");
            resultAnimals = new ArrayList<>();

            for(Animal animal : animals){
                if(animal.getCategory().equalsIgnoreCase(categoryValue)){
                    resultAnimals.add(animal);
                }
            }
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        AnimalsPerCategoryAdapter animalsPerCategoryAdapter = new AnimalsPerCategoryAdapter(resultAnimals,this);
        rvRecyclerView.setLayoutManager(layoutManager);
        rvRecyclerView.setAdapter(animalsPerCategoryAdapter);

    }
}
