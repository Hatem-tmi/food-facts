package com.toumi.foodfacts.data.provider.api.dto;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class ESelectedImages {

    private ESelectedImage front;
    private ESelectedImage ingredients;
    private ESelectedImage nutrition;

    public ESelectedImage getFront() {
        return front;
    }

    public void setFront(ESelectedImage front) {
        this.front = front;
    }

    public ESelectedImage getIngedients() {
        return ingredients;
    }

    public void setIngedients(ESelectedImage ingredients) {
        this.ingredients = ingredients;
    }

    public ESelectedImage getNutrition() {
        return nutrition;
    }

    public void setNutrition(ESelectedImage nutrition) {
        this.nutrition = nutrition;
    }

    @Override
    public String toString() {
        return "ESelectedImages{" +
                "front=" + front +
                ", ingredients=" + ingredients +
                ", nutrition=" + nutrition +
                '}';
    }
}
