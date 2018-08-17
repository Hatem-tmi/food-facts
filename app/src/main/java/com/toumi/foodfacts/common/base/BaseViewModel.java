package com.toumi.foodfacts.common.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.toumi.foodfacts.FoodFactsApp;
import com.toumi.foodfacts.common.event.BaseEvent;
import com.toumi.foodfacts.common.event.RxBus;
import com.toumi.foodfacts.data.DataManagerAccessor;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public abstract class BaseViewModel extends AndroidViewModel {

    @Inject
    protected DataManagerAccessor dataManagerAccessor;

    @Inject
    protected RxBus rxBus;

    private CompositeDisposable subscriptions = new CompositeDisposable();
    private CompositeDisposable busEventSubscriptions = new CompositeDisposable();

    public BaseViewModel(@NonNull Application application) {
        super(application);
        FoodFactsApp.getAppComponent().inject(this);
    }

    public void onCreated() {
        subscribeBusEvents();
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
        clearSubs();
    }

    public void onStop() {
    }

    public void onDestroy() {
        unsubscribeBusEvents();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    protected <R> void subscribe(Observable<R> observable, Consumer<? super R> onNext, Consumer<Throwable> onError) {
        this.subscriptions.add(observable.subscribe(onNext, onError));
    }

    protected void subscribe(Completable completable, Action onComplete, Consumer<? super Throwable> onError) {
        completable.doOnSubscribe(this.subscriptions::add).subscribe(onComplete, onError);
    }

    protected void clearSubs() {
        subscriptions.clear();
    }

    private void subscribeBusEvents() {
        Observable observable = rxBus.toObservable().doOnNext(this::onBusEventReceived);
        busEventSubscriptions.add(observable.subscribeOn(AndroidSchedulers.mainThread()).subscribe());
    }

    private void unsubscribeBusEvents() {
        busEventSubscriptions.clear();
    }

    protected void onBusEventReceived(BaseEvent event) {
    }
}
