package com.toumi.foodfacts.data.provider.database;

import android.arch.persistence.room.Room;

import com.toumi.foodfacts.FoodFactsApp;
import com.toumi.foodfacts.data.model.Product;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
@Singleton
public class DatabaseProvider {

    private AppDatabase db;

    @Inject
    public DatabaseProvider() {
        db = Room.databaseBuilder(FoodFactsApp.getAppComponent().getContext(),
                AppDatabase.class, "foodfacts-database").build();
    }

    public Observable<List<Long>> insertProducts(Product... products) {
        return Observable.fromCallable(() -> db.productDao().insertProducts(products));
    }

    public Observable<List<Product>> loadProducts() {
        return db.productDao().loadAllProducts().toObservable();
    }

    public Observable<Product> loadProduct(String code) {
        return db.productDao().loadProductByCode(code).map(result -> {
            if (result != null && result.size() > 0)
                return result.get(0);
            else
                return null;
        }).toObservable();
    }
}
