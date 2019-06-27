package com.example.week2day3zoorecyclerandlistviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CategoriesListView extends AppCompatActivity {

    ListView lvCategories;
    AnimalDatabaseHelper helper;
    String categoryValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_list_view);

        lvCategories = findViewById(R.id.lvCategories);
        helper = new AnimalDatabaseHelper();

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, helper.getCategories());

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
                animalsBundle.putParcelableArrayList("animals", helper.getAnimals());
                animalsBundle.putString("categoryValue", categoryValue);
                intent.putExtras(animalsBundle);
                startActivity(intent);
            }

        });


    }


    public void animalDetails(View view) {

    }
}
