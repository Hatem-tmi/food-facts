package com.toumi.foodfacts.common.event;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class ProductEvent extends BaseEvent {
    private String code;

    public ProductEvent(String productCode) {
        super(ProductEvent.class.getSimpleName());
        this.code = productCode;
    }

    public String getCode() {
        return code;
    }
}
