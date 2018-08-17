package com.toumi.foodfacts.data.provider.api.dto;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class EIngredient {
    private String id;
    private String text;
    private int rank;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "EIngredient{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", rank=" + rank +
                '}';
    }
}
