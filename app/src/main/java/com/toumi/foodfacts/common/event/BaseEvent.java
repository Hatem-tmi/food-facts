package com.toumi.foodfacts.common.event;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class BaseEvent {
    protected String name;

    public BaseEvent(String name) {
        this.name = name;
    }

    public String getNameEvent() {
        return name;
    }
}
