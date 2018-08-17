package com.toumi.foodfacts.data.provider.api.dto;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class ESelectedImage {
    private ESelectedImageValue thumb;
    private ESelectedImageValue display;
    private ESelectedImageValue small;

    public ESelectedImageValue getThumb() {
        return thumb;
    }

    public void setThumb(ESelectedImageValue thumb) {
        this.thumb = thumb;
    }

    public ESelectedImageValue getDisplay() {
        return display;
    }

    public void setDisplay(ESelectedImageValue display) {
        this.display = display;
    }

    public ESelectedImageValue getSmall() {
        return small;
    }

    public void setSmall(ESelectedImageValue small) {
        this.small = small;
    }

    @Override
    public String toString() {
        return "ESelectedImage{" +
                "thumb=" + thumb +
                ", display=" + display +
                ", small=" + small +
                '}';
    }
}
