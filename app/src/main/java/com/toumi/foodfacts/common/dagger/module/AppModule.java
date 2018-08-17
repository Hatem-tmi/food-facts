package com.toumi.foodfacts.common.dagger.module;

import android.app.Application;
import android.content.Context;

import com.toumi.foodfacts.common.dagger.annotation.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
@Module
public class AppModule {
    private Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }
}
