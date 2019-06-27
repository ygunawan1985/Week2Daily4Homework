package com.example.week2day3zoorecyclerandlistviews;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    private String name;
    private String category;
    private String description;
    private String sound;

    public Animal() {
    }

    public Animal(String name, String category, String description, String sound) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.sound = sound;
    }

    protected Animal(Parcel in) {
        name = in.readString();
        category = in.readString();
        description = in.readString();
        sound = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(category);
        parcel.writeString(description);
        parcel.writeString(sound);
    }
}
