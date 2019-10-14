package com.themtgdeckgenius.giphysearchjava.persistence;

import com.themtgdeckgenius.giphysearchjava.persistence.daos.FavoritesDAO;
import com.themtgdeckgenius.giphysearchjava.persistence.tables.Favorite;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Favorite.class}, version = 1, exportSchema = false)
public abstract class FavoritesDatabase extends RoomDatabase {

    public abstract FavoritesDAO favoritesDAO();
}
