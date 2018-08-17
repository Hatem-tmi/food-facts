package com.toumi.foodfacts.data.provider.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.toumi.foodfacts.data.model.Product;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProductDao productDao();
}