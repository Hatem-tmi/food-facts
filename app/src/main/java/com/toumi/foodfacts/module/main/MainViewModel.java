package com.toumi.foodfacts.module.main;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.toumi.foodfacts.common.base.BaseViewModel;
import com.toumi.foodfacts.common.base.SingleLiveEvent;

import timber.log.Timber;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class MainViewModel extends BaseViewModel {
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    public SingleLiveEvent<String> showMessage = new SingleLiveEvent<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetchProductByBarcodeNumber(String barcodeNumber) {
        this.isLoading.setValue(true);

        subscribe(dataManagerAccessor.fetchProduct(barcodeNumber), product -> {
            this.isLoading.setValue(false);
            Timber.d(product.toString());
            showMessage.setValue("Success fetching product for code " + barcodeNumber);
        }, error -> {
            this.isLoading.setValue(false);
            Timber.e(error);
            showMessage.setValue("Error fetching product for code " + barcodeNumber);
        });
    }
}