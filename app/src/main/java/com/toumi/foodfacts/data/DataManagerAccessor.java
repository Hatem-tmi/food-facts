package com.toumi.foodfacts.data;

import com.toumi.foodfacts.data.model.Product;
import com.toumi.foodfacts.data.provider.api.NetworkProvider;
import com.toumi.foodfacts.data.provider.database.DatabaseProvider;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.CompletableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
@Singleton
public class DataManagerAccessor extends DataManager {

    @Inject
    public DataManagerAccessor(NetworkProvider networkProvider, DatabaseProvider databaseProvider) {
        this.networkProvider = networkProvider;
        this.databaseProvider = databaseProvider;
    }

    public void onTerminate() {
        _onTerminate();
    }

    /**
     * Transformers
     */
    public <T> ObservableTransformer<T, T> async() {
        return o -> o.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    public <T> ObservableTransformer<T, T> io() {
        return o -> o.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public CompletableTransformer cAsync() {
        return o -> o.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    public CompletableTransformer cIo() {
        return o -> o.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public <T> ObservableTransformer<T, T> main() {
        return o -> o.observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Api calls
     */
    public Observable<Product> fetchProduct(String barcodeNumber) {
        return _fetchProduct(barcodeNumber).compose(io());
    }

    /**
     * Database queries
     */
    public Observable<List<Product>> loadProductsFromCache() {
        return _loadProductsFromCache().compose(async());
    }

    public Observable<Product> loadProductFromCache(String code) {
        return _loadProductFromCache(code).compose(async());
    }
}
