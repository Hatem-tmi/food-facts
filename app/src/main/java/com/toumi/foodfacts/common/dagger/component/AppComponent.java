package com.toumi.foodfacts.common.dagger.component;

import android.app.Application;
import android.content.Context;

import com.toumi.foodfacts.common.base.BaseViewModel;
import com.toumi.foodfacts.common.dagger.annotation.ApplicationContext;
import com.toumi.foodfacts.common.dagger.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(Application application);

    void inject(BaseViewModel viewModel);

    @ApplicationContext
    Context getContext();

    Application getApplication();
}