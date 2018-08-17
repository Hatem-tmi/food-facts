package com.toumi.foodfacts.data.provider.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class ENutrientLevels {
    private String sugars;
    private String fat;
    private String salt;

    @SerializedName("saturated-fat")
    private String saturatedFat;

    public String getSugars() {
        return sugars;
    }

    public void setSugars(String sugars) {
        this.sugars = sugars;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(String saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    @Override
    public String toString() {
        return "ENutrientLevels{" +
                "sugars='" + sugars + '\'' +
                ", fat='" + fat + '\'' +
                ", salt='" + salt + '\'' +
                ", saturatedFat='" + saturatedFat + '\'' +
                '}';
    }
}
