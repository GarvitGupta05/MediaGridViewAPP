package com.example.garvitgupta.model;

/**
 * Created by Garvit Gupta on 8/27/2016.
 */
public abstract class Media {

    private String name;
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
