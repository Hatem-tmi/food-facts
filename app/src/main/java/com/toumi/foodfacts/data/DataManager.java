package com.toumi.foodfacts.data;

import com.toumi.foodfacts.data.model.Product;
import com.toumi.foodfacts.data.provider.api.NetworkProvider;
import com.toumi.foodfacts.data.provider.database.DatabaseProvider;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
@Singleton
public abstract class DataManager {

    protected NetworkProvider networkProvider;
    protected DatabaseProvider databaseProvider;

    protected void _onTerminate() {
    }

    protected Observable<Product> _fetchProduct(String barcodeNumber) {
        return networkProvider.getProduct(barcodeNumber).flatMap(this::_saveProduct);
    }

    protected Observable<Product> _saveProduct(Product product) {
        return databaseProvider.insertProducts(product).map(result -> product);
    }

    protected Observable<List<Product>> _loadProductsFromCache() {
        return databaseProvider.loadProducts();
    }

    protected Observable<Product> _loadProductFromCache(String code) {
        return databaseProvider.loadProduct(code);
    }
}
