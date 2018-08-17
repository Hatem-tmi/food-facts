package com.toumi.foodfacts.module.details;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.toumi.foodfacts.common.base.BaseViewModel;
import com.toumi.foodfacts.common.base.SingleLiveEvent;
import com.toumi.foodfacts.common.event.BaseEvent;
import com.toumi.foodfacts.common.event.ProductEvent;
import com.toumi.foodfacts.data.model.Product;

import timber.log.Timber;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class DetailsViewModel extends BaseViewModel {

    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    public SingleLiveEvent<String> showMessage = new SingleLiveEvent<>();
    public MutableLiveData<Product> productObservable = new MutableLiveData<>();
    public SingleLiveEvent<String> showPhotoPreviewScreen = new SingleLiveEvent<>();

    private boolean isPaused = false;

    public DetailsViewModel(@NonNull Application application) {
        super(application);
        this.isLoading.setValue(false);
    }

    @Override
    public void onResume() {
        super.onResume();
        isPaused = false;
    }

    @Override
    public void onPause() {
        isPaused = true;
        super.onPause();
    }

    @Override
    protected void onBusEventReceived(BaseEvent event) {
        if (event instanceof ProductEvent && !isPaused) {
            ProductEvent productEvent = (ProductEvent) event;
            loadProductFromCache(productEvent.getCode());
        }
    }

    void loadProductFromCache(String code) {
        this.isLoading.setValue(true);

        subscribe(dataManagerAccessor.loadProductFromCache(code), result -> {
            this.isLoading.setValue(false);
            Timber.d(result.toString());
            showMessage.setValue("Success loading product from cache");
            productObservable.setValue(result);
        }, error -> {
            this.isLoading.setValue(false);
            Timber.e(error);
            showMessage.setValue("Failed loading product from cache");
            productObservable.setValue(null);
        });
    }

    public void showPhotoPreview(String imageUrl) {
        showPhotoPreviewScreen.setValue(imageUrl);
    }
}
