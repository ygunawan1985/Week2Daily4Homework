package com.example.week2day3zoorecyclerandlistviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnimalDetails extends AppCompatActivity {

    TextView tvName;
    TextView tvCategory;
    TextView tvDescription;
    Button btnSound;
    String mpSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        tvName = findViewById(R.id.tvName);
        tvCategory = findViewById(R.id.tvCategory);
        tvDescription = findViewById(R.id.tvDescription);
        btnSound = findViewById(R.id.btnSound);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            Animal animal = bundle.getParcelable("animal");
            tvName.setText(animal.getName());
            tvCategory.setText(animal.getCategory());
            tvDescription.setText(animal.getDescription());
            mpSound = animal.getSound();
        }

    }

    public void onClick(View view) {
        playSong(mpSound);
    }

    public void playSong(String mpSound) {
        // Play song
        MediaPlayer mp = new MediaPlayer();
        mp.reset();// stops any current playing song

        switch(mpSound){
            case "cat":
                mp = MediaPlayer.create(this, R.raw.cat);
                break;

            case "croaker":
                mp = MediaPlayer.create(this, R.raw.croaker);
                break;

            case "crocodile":
                mp = MediaPlayer.create(this, R.raw.crocodile);
                break;

            case "dog":
                mp = MediaPlayer.create(this, R.raw.dog);
                break;

            case "eagle":
                mp = MediaPlayer.create(this, R.raw.eagle);
                break;

            case "falcon":
                mp = MediaPlayer.create(this, R.raw.falcon);
                break;

            case "frog":
                mp = MediaPlayer.create(this, R.raw.frog);
                break;

            case "penguin":
                mp = MediaPlayer.create(this, R.raw.penguin);
                break;

            case "salamander":
                mp = MediaPlayer.create(this, R.raw.salamander);
                break;

            case "snake":
                mp = MediaPlayer.create(this, R.raw.snake);
                break;
        }

        mp.start(); // starting mediaplayer
    }
}
