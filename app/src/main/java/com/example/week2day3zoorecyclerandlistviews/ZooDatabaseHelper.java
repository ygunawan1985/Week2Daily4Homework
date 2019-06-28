package com.example.week2day3zoorecyclerandlistviews;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ZooDatabaseHelper extends SQLiteOpenHelper {

    public ZooDatabaseHelper(Context context) {
        super(context, ZooDatabaseContract.DATABASE_NAME, null, ZooDatabaseContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ZooDatabaseContract.getCreateQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            sqLiteDatabase.execSQL(ZooDatabaseContract.DROP_QUERY);
            onCreate(sqLiteDatabase);
        }
    }

    public void insertAnimal(Animal animal){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ZooDatabaseContract.COLUMN_NAME, animal.getName());
        contentValues.put(ZooDatabaseContract.COLUMN_CATEGORY, animal.getCategory());
        contentValues.put(ZooDatabaseContract.COLUMN_DESCRIPTION, animal.getDescription());
        contentValues.put(ZooDatabaseContract.COLUMN_SOUND, animal.getSound());

        database.insert(ZooDatabaseContract.TABLE_NAME, null, contentValues);
        database.close();
    }

    public ArrayList<Animal> getAllAnimals(){
        SQLiteDatabase database = this.getReadableDatabase();
        ArrayList<Animal> returnList = new ArrayList<>();

        Cursor cursor = database.rawQuery(ZooDatabaseContract.SELECT_ALL_QUERY, null);
        if(cursor.moveToFirst()){
            do {
                String name = cursor.getString(cursor.getColumnIndex(ZooDatabaseContract.COLUMN_NAME));
                String category = cursor.getString(cursor.getColumnIndex(ZooDatabaseContract.COLUMN_CATEGORY));
                String description = cursor.getString(cursor.getColumnIndex(ZooDatabaseContract.COLUMN_DESCRIPTION));
                String sound = cursor.getString(cursor.getColumnIndex(ZooDatabaseContract.COLUMN_SOUND));

                returnList.add(new Animal(name, category, description, sound));
            } while(cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return returnList;
    }

    public ArrayList<Animal> getAnimalsByCategory(String requestCategory){
        SQLiteDatabase database = this.getReadableDatabase();
        ArrayList<Animal> returnList = new ArrayList<>();

        Cursor cursor = database.rawQuery(ZooDatabaseContract.getByCategoryQuery(requestCategory), null);
        if(cursor.moveToFirst()){
            do {
                String name = cursor.getString(cursor.getColumnIndex(ZooDatabaseContract.COLUMN_NAME));
                String category = cursor.getString(cursor.getColumnIndex(ZooDatabaseContract.COLUMN_CATEGORY));
                String description = cursor.getString(cursor.getColumnIndex(ZooDatabaseContract.COLUMN_DESCRIPTION));
                String sound = cursor.getString(cursor.getColumnIndex(ZooDatabaseContract.COLUMN_SOUND));

                returnList.add(new Animal(name, category, description, sound));
            } while(cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return returnList;
    }

    public Animal getAnimal(String requestName){
        SQLiteDatabase database = this.getReadableDatabase();
        Animal animal = new Animal();

        Cursor cursor = database.rawQuery(ZooDatabaseContract.getByAnimalQuery(requestName), null);
        if(cursor.moveToFirst()){
            animal.setName(cursor.getString(cursor.getColumnIndex(ZooDatabaseContract.COLUMN_NAME)));
            animal.setCategory(cursor.getString(cursor.getColumnIndex(ZooDatabaseContract.COLUMN_CATEGORY)));
            animal.setDescription(cursor.getString(cursor.getColumnIndex(ZooDatabaseContract.COLUMN_DESCRIPTION)));
            animal.setSound(cursor.getString(cursor.getColumnIndex(ZooDatabaseContract.COLUMN_SOUND)));
        }

        cursor.close();
        database.close();
        return animal;
    }


}
