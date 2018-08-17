package com.toumi.foodfacts.module.list;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.toumi.foodfacts.common.base.BaseViewModel;
import com.toumi.foodfacts.common.event.ProductEvent;
import com.toumi.foodfacts.data.model.Product;

import java.util.List;

import timber.log.Timber;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class ProductsViewModel extends BaseViewModel {
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    public MutableLiveData<List<Product>> productsObservable = new MutableLiveData<>();

    public ProductsViewModel(@NonNull Application application) {
        super(application);
        this.isLoading.setValue(false);
        this.productsObservable.setValue(null);
    }

    void loadDataFromCache() {
        this.isLoading.setValue(true);

        subscribe(dataManagerAccessor.loadProductsFromCache(), result -> {
            this.isLoading.setValue(false);
            Timber.d(result.toString());
            productsObservable.setValue(result);

            // Update Details view with first item
            if (!result.isEmpty()) {
                showProductDetails(result.get(0));
            }
        }, error -> {
            this.isLoading.setValue(false);
            Timber.e(error);
            productsObservable.setValue(null);
        });
    }

    void showProductDetails(Product product) {
        rxBus.send(new ProductEvent(product.getCode()));
    }
}
