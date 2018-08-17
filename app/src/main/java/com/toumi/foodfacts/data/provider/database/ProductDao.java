package com.toumi.foodfacts.data.provider.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.toumi.foodfacts.data.model.Product;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
@Dao
public interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertProducts(Product... products);

    @Query("SELECT * FROM product ORDER BY creationDate DESC")
    Flowable<List<Product>> loadAllProducts();

    @Query("SELECT * FROM product WHERE code LIKE :code")
    Single<List<Product>> loadProductByCode(String code);
}