package com.toumi.foodfacts.data.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Calendar;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
@Entity(tableName = "product")
public class Product {
    @PrimaryKey
    @NonNull
    private String code;
    private String name;
    private String imageUrl;
    private String genericName;
    private String brands;
    private String categories;
    private String link;

    private String ingredientsImageUrl;
    private String ingredients;

    @Embedded
    private Nutriments nutriments;

    private long creationDate = Calendar.getInstance().getTimeInMillis();

    @Ignore
    private boolean isSelected = false;

    @NonNull
    public String getCode() {
        return code;
    }

    public void setCode(@NonNull String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getIngredientsImageUrl() {
        return ingredientsImageUrl;
    }

    public void setIngredientsImageUrl(String ingredientsImageUrl) {
        this.ingredientsImageUrl = ingredientsImageUrl;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Nutriments getNutriments() {
        return nutriments;
    }

    public void setNutriments(Nutriments nutriments) {
        this.nutriments = nutriments;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", genericName='" + genericName + '\'' +
                ", brands='" + brands + '\'' +
                ", categories='" + categories + '\'' +
                ", link='" + link + '\'' +
                ", ingredientsImageUrl='" + ingredientsImageUrl + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", nutriments=" + nutriments +
                ", creationDate=" + creationDate +
                ", isSelected=" + isSelected +
                '}';
    }
}
