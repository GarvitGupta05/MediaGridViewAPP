package com.example.garvitgupta.model;

import android.graphics.Bitmap;

/**
 * Created by Garvit Gupta on 8/27/2016.
 */
public class Photo extends Media {

    private String width;
    private String height;
    private Bitmap image;

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
