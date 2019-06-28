package com.example.week2day3zoorecyclerandlistviews;

import java.util.Locale;

public class ZooDatabaseContract {

    public static final String DATABASE_NAME = "zoo_db";
    public static final int DATABASE_VERSION = 8;
    public static final String TABLE_NAME = "animal_table";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_SOUND = "sound";

    public static final String DROP_QUERY = String.format("DROP TABLE %s", TABLE_NAME);
    public static final String SELECT_ALL_QUERY = String.format("SELECT * FROM %s", TABLE_NAME);

    public static final String getCreateQuery(){
        return String.format(Locale.US, "CREATE TABLE %s( %s TEXT PRIMARY_KEY, %s TEXT, %s TEXT, %s TEXT)",
                TABLE_NAME, COLUMN_NAME, COLUMN_CATEGORY, COLUMN_DESCRIPTION, COLUMN_SOUND);
    }

    public static String getByCategoryQuery(String category){
        return String.format("%s WHERE %s = \"%s\"", SELECT_ALL_QUERY, COLUMN_CATEGORY, category);
    }

    public static String getByAnimalQuery(String name){
        return String.format("%s WHERE %s = \"%s\"", SELECT_ALL_QUERY, COLUMN_NAME, name);
    }
}
