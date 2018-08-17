package com.toumi.foodfacts;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.toumi.foodfacts.common.dagger.component.AppComponent;
import com.toumi.foodfacts.common.dagger.component.DaggerAppComponent;
import com.toumi.foodfacts.common.dagger.module.AppModule;
import com.toumi.foodfacts.data.DataManagerAccessor;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class FoodFactsApp extends Application {
    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Inject
    DataManagerAccessor dataManagerAccessor;

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();
        initTimber();
        initStethoMonitoring();
    }

    @Override
    public void onTerminate() {
        dataManagerAccessor.onTerminate();
        super.onTerminate();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    private void initTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());
    }

    private void initStethoMonitoring() {
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this);
    }
}
