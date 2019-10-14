package com.themtgdeckgenius.giphysearchjava.persistence;

import android.content.Context;

import com.themtgdeckgenius.giphysearchjava.persistence.tables.Favorite;

import java.util.List;

import androidx.room.Room;

public class FavoriteRepository {

    private String DB_NAME = "db_favorites";
    private FavoritesDatabase favoritesDatabase;

    public FavoriteRepository(Context context) {
        favoritesDatabase = Room.databaseBuilder(context, FavoritesDatabase.class, DB_NAME).allowMainThreadQueries().build();
    }

    public void insertFavorite(String url) {
        Favorite favorite = new Favorite();
        favorite.setGiphyUrl(url);
        insertFavorite(favorite);
    }

    private void insertFavorite(final Favorite favorite) {
        favoritesDatabase.favoritesDAO().insert(favorite);
    }

    public void deleteTask(final String url) {
        favoritesDatabase.favoritesDAO().deleteFavorite(url);
    }

    public List<Favorite> getFaroites() {
        return favoritesDatabase.favoritesDAO().getFaroites();
    }

    public boolean checkIfPresent(String url) {
        return favoritesDatabase.favoritesDAO().checkIfPresent(url);
    }

    public void clearTable() {
        favoritesDatabase.favoritesDAO().clearTable();
    }
}
