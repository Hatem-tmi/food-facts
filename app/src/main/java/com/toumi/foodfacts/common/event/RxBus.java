package com.toumi.foodfacts.common.event;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
@Singleton
public class RxBus {
    private final Subject<BaseEvent> bus = PublishSubject.create();

    @Inject
    public RxBus() {
    }

    public void send(BaseEvent o) {
        bus.onNext(o);
    }

    public Observable<BaseEvent> toObservable() {
        return bus;
    }

    public boolean hasObservers() {
        return bus.hasObservers();
    }
}