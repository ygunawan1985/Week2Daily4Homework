package com.example.week2day3zoorecyclerandlistviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CategoriesListView extends AppCompatActivity {

    ListView lvCategories;
    ZooDatabaseHelper zooDatabaseHelper;
    //AnimalDatabaseHelper helper;
    String categoryValue;
    String[] categories = null;
    //SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_list_view);

        categories = new String[]{"Mammals", "Birds", "Fish", "Reptiles", "Amphibians"};
        lvCategories = findViewById(R.id.lvCategories);
        zooDatabaseHelper = new ZooDatabaseHelper(this);

        zooDatabaseHelper.insertAnimal(new Animal("Dog", "Mammals", "Man's best friend.", "dog"));
        zooDatabaseHelper.insertAnimal(new Animal("Cat", "Mammals", "Second most popular pet and sometimes called kitty.", "cat"));
        zooDatabaseHelper.insertAnimal(new Animal("Eagle", "Birds", "National emblem of the United States.", "eagle"));
        zooDatabaseHelper.insertAnimal(new Animal("Falcon", "Birds", "The bird of prey that primarily hunt other animals.", "falcon"));
        zooDatabaseHelper.insertAnimal(new Animal("Croaker", "Fish", "The Croaker is quite possibly the most underrated fish on the Gulf Coast. Known lovingly as “frogfish” for its signature croaking sound, the Croaker also has a reputation for stealing bait.", "croaker"));
        zooDatabaseHelper.insertAnimal(new Animal("Penguin", "Birds", "Penguins are a group of aquatic flightless birds. They live almost exclusively in the Southern Hemisphere, with only one species, the Galapagos penguin, found north of the equator.", "penguin"));
        zooDatabaseHelper.insertAnimal(new Animal("Crocodile", "Reptiles", "Large semi-aquatic reptiles that live throughout the tropics in Africa, Asia, the Americas and Australia.", "crocodile"));
        zooDatabaseHelper.insertAnimal(new Animal("Snake", "Reptiles", "Snakes have skulls with several more joints than their lizard ancestors, enabling them to swallow prey much larger than their heads with their highly mobile jaws.", "snake"));
        zooDatabaseHelper.insertAnimal(new Animal("Frog", "Amphibians", "Frogs are valued as food by humans and also have many cultural roles in literature, symbolism and religion.", "frog"));
        zooDatabaseHelper.insertAnimal(new Animal("Salamander", "Amphibians", "Salamanders rarely have more than four toes on their front legs and five on their rear legs, but some species have fewer digits and others lack hind limbs.", "salamander"));

        //sharedPreferences = getSharedPreferences("shared_pref", MODE_PRIVATE);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, categories);

        // Assign adapter to ListView
        lvCategories.setAdapter(adapter);

        // ListView Item Click Listener
        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                categoryValue = (String)lvCategories.getItemAtPosition(position);

                Intent intent = new Intent(parent.getContext(), AnimalsRecyclerView.class);

                Bundle animalsBundle = new Bundle();
                animalsBundle.putParcelableArrayList("animals", zooDatabaseHelper.getAnimalsByCategory(categoryValue));
                //animalsBundle.putString("categoryValue", categoryValue);
                intent.putExtras(animalsBundle);
                startActivity(intent);
            }

        });


    }

//    private void setCategoryInSharedPref(String category){
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("category", category);
//        editor.apply(); //returns nothing
//        //editor.commit(); returns a boolean value
//        editor.clear();
//    }
}
