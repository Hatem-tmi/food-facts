package com.toumi.foodfacts.data.provider.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class ESelectedImageValue {
    @SerializedName("fr")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ESelectedImage{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
