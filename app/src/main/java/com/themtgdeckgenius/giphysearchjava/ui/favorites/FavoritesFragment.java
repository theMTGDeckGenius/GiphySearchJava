package com.themtgdeckgenius.giphysearchjava.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.themtgdeckgenius.giphysearchjava.R;
import com.themtgdeckgenius.giphysearchjava.adapters.GiphyAdapter;
import com.themtgdeckgenius.giphysearchjava.listeners.FavoritesActionsListener;
import com.themtgdeckgenius.giphysearchjava.persistence.FavoriteRepository;
import com.themtgdeckgenius.giphysearchjava.ui.dialogs.ActionsDialog;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FavoritesFragment extends Fragment {
    private RecyclerView mGiphyDisplay;
    private GiphyAdapter mGiphyAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FavoriteRepository favoriteRepository = new FavoriteRepository(getContext());

        View root = inflater.inflate(R.layout.fragment_favorites, container, false);
        mGiphyDisplay = root.findViewById(R.id.recycler_view_favorite);
        mGiphyDisplay.setLayoutManager( new GridLayoutManager(getContext(), 2));
        mGiphyAdapter = new GiphyAdapter(favoriteRepository.getFaroites(), getContext(), new FavoritesActionsListener() {
            @Override
            public void showShareDialog(String url) {
                ActionsDialog dialog = new ActionsDialog(url);
                dialog.show(getFragmentManager(), "favorites_fragment_dialog");
            }
        });
        mGiphyDisplay.setAdapter(mGiphyAdapter);
        return root;
    }


}