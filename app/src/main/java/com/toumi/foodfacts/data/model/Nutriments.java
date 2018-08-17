package com.toumi.foodfacts.data.model;

import android.arch.persistence.room.ColumnInfo;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class Nutriments {
    @ColumnInfo(name = "nutriment_image_url")
    private String imageUrl;

    @ColumnInfo(name = "nutriment_grade")
    private String grade;

    @ColumnInfo(name = "nutriment_energy100g_kj")
    private String energy100gKj;

    @ColumnInfo(name = "nutriment_energy100g_kcal")
    private String energy100gKcal;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEnergy100gKj() {
        return energy100gKj;
    }

    public void setEnergy100gKj(String energy100gKj) {
        this.energy100gKj = energy100gKj;
    }

    public String getEnergy100gKcal() {
        return energy100gKcal;
    }

    public void setEnergy100gKcal(String energy100gKcal) {
        this.energy100gKcal = energy100gKcal;
    }

    @Override
    public String toString() {
        return "Nutriments{" +
                "imageUrl='" + imageUrl + '\'' +
                ", grade='" + grade + '\'' +
                ", energy100gKj='" + energy100gKj + '\'' +
                ", energy100gKcal='" + energy100gKcal + '\'' +
                '}';
    }
}
