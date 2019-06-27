package com.example.week2day3zoorecyclerandlistviews;

import java.util.ArrayList;

public class AnimalDatabaseHelper {

    private ArrayList<Animal> animals;
    private String[] categories;

    public AnimalDatabaseHelper() {
        animals = new ArrayList<>();
        populateAnimals();
        categories = new String[]{"Mammals", "Birds", "Fish", "Reptiles", "Amphibians"};
    }

    public void populateAnimals(){
        animals.add(new Animal("Dog", "Mammals", "Man's best friend.", "dog"));
        animals.add(new Animal("Cat", "Mammals", "Second most popular pet and sometimes called kitty.", "cat"));
        animals.add(new Animal("Eagle", "Birds", "National emblem of the United States.", "eagle"));
        animals.add(new Animal("Falcon", "Birds", "The bird of prey that primarily hunt other animals.", "falcon"));
        animals.add(new Animal("Croaker", "Fish", "The Croaker is quite possibly the most underrated fish on the Gulf Coast. Known lovingly as “frogfish” for its signature croaking sound, the Croaker also has a reputation for stealing bait.", "croaker"));
        animals.add(new Animal("Penguin", "Birds", "Penguins are a group of aquatic flightless birds. They live almost exclusively in the Southern Hemisphere, with only one species, the Galapagos penguin, found north of the equator.", "penguin"));
        animals.add(new Animal("Crocodile", "Reptiles", "Large semi-aquatic reptiles that live throughout the tropics in Africa, Asia, the Americas and Australia.", "crocodile"));
        animals.add(new Animal("Snake", "Reptiles", "Snakes have skulls with several more joints than their lizard ancestors, enabling them to swallow prey much larger than their heads with their highly mobile jaws.", "snake"));
        animals.add(new Animal("Frog", "Amphibians", "Frogs are valued as food by humans and also have many cultural roles in literature, symbolism and religion.", "frog"));
        animals.add(new Animal("Salamander", "Amphibians", "Salamanders rarely have more than four toes on their front legs and five on their rear legs, but some species have fewer digits and others lack hind limbs.", "salamander"));
    }

    public String[] getCategories(){
        return categories;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
