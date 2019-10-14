package com.themtgdeckgenius.giphysearchjava.persistence.daos;

import com.themtgdeckgenius.giphysearchjava.persistence.tables.Favorite;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface FavoritesDAO {

    @Insert
    void insert(Favorite favorite);

    @Query("select * from favorite order by id")
    List<Favorite> getFaroites();

    @Query("delete from Favorite where giphyUrl = :url")
    void deleteFavorite(String url);

    @Query("delete from Favorite")
    void clearTable();

    @Query("select exists(select 1 from Favorite where giphyUrl = :url limit 1)")
    boolean checkIfPresent(String url);

}
