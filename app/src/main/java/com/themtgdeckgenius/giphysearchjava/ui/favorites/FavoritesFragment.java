package com.themtgdeckgenius.giphysearchjava.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.themtgdeckgenius.giphysearchjava.R;
import com.themtgdeckgenius.giphysearchjava.adapters.GiphyAdapter;
import com.themtgdeckgenius.giphysearchjava.listeners.EndOfListListener;
import com.themtgdeckgenius.giphysearchjava.networking.objects.Data;
import com.themtgdeckgenius.giphysearchjava.persistence.FavoriteRepository;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FavoritesFragment extends Fragment {
    private RecyclerView mGiphyDisplay;
    private GiphyAdapter mGiphyAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FavoriteRepository favoriteRepository = new FavoriteRepository(getContext());

        View root = inflater.inflate(R.layout.fragment_random, container, false);
        mGiphyDisplay = root.findViewById(R.id.recycler_view_favorite);
        mGiphyDisplay.setLayoutManager( new GridLayoutManager(getContext(), 2));
        mGiphyAdapter = new GiphyAdapter(favoriteRepository.getFaroites(), getContext());
        mGiphyDisplay.setAdapter(mGiphyAdapter);
        return root;
    }


}