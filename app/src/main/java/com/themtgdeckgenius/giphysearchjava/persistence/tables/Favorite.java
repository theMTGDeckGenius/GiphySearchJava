package com.themtgdeckgenius.giphysearchjava.persistence.tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Favorite {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String giphyUrl;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGiphyUrl() {
        return giphyUrl;
    }

    public void setGiphyUrl(String giphyUrl) {
        this.giphyUrl = giphyUrl;
    }

}
