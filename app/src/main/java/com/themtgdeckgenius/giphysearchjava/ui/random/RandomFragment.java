package com.themtgdeckgenius.giphysearchjava.ui.random;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.themtgdeckgenius.giphysearchjava.BuildConfig;
import com.themtgdeckgenius.giphysearchjava.MainActivity;
import com.themtgdeckgenius.giphysearchjava.R;
import com.themtgdeckgenius.giphysearchjava.networking.GiphyApiService;
import com.themtgdeckgenius.giphysearchjava.networking.objects.RandomObject;
import com.themtgdeckgenius.giphysearchjava.persistence.FavoriteRepository;
import com.themtgdeckgenius.giphysearchjava.ui.dialogs.ActionsDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomFragment extends Fragment {

    private TextView mPageTitale;
    private ImageView mGiphyContainer;
    private ImageView mFavorite;
    private String mFavoriteURL;
    private FavoriteRepository favoriteRepository;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoriteRepository = new FavoriteRepository(getContext());
        View root = inflater.inflate(R.layout.fragment_random, container, false);
        mPageTitale = root.findViewById(R.id.text_random_title);
        mGiphyContainer = root.findViewById(R.id.giphy_container);
        mGiphyContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionsDialog dialog = new ActionsDialog(mFavoriteURL);
                dialog.show(getFragmentManager(), "share_dialog");
            }
        });
        mFavorite = root.findViewById(R.id.favorite);
        mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFavorite.setImageResource(R.drawable.ic_star_favorite);
                favoriteRepository.insertFavorite(mFavoriteURL);
            }
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(terms.size());
        getRandomGiphy(terms.get(randomInt));

    }

    private void getRandomGiphy(final String term) {
        GiphyApiService giphyApiService = GiphyApiService.service;
        Call<RandomObject> call = giphyApiService.randomGiphy(BuildConfig.GIPHY_API_KEY, term, ((MainActivity) getActivity()).getRating());
        call.enqueue(new Callback<RandomObject>() {
            @Override
            public void onResponse(Call<RandomObject> call, Response<RandomObject> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        mFavoriteURL = response.body().getData().getImageUrl();
                        Glide.with(getContext())
                                .asGif()
                                .load(mFavoriteURL)
                                .thumbnail(0.1f)
                                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                                .centerCrop()
                                .into(new CustomTarget<GifDrawable>() {
                                    @Override
                                    public void onResourceReady(@NonNull GifDrawable resource, @Nullable Transition<? super GifDrawable> transition) {
                                        mGiphyContainer.setImageDrawable(resource);
                                        mPageTitale.setText("Search Term: "+term);
                                        resource.start();
                                    }

                                    @Override
                                    public void onLoadCleared(@Nullable Drawable placeholder) {

                                    }
                                });
                    }
                }
            }

            @Override
            public void onFailure(Call<RandomObject> call, Throwable t) {

            }
        });
    }

    private ArrayList<String> terms = new ArrayList<>(Arrays.asList("weather",
            "map",
            "translate",
            "calculator",
            "thesaurus",
            "powerball",
            "donald trump",
            "nfl",
            "trump",
            "periodic table",
            "face olympics",
            "cool math",
            "timer",
            "happy wheels",
            "overwatch",
            "league of legends",
            "discover",
            "movies",
            "hillary clinton",
            "game of thrones",
            "flying",
            "animal jam",
            "games",
            "bernie sanders",
            "entertainment",
            "goo",
            "rick and morty",
            "irs",
            "star wars",
            "deadpool",
            "sports",
            "bitcoin",
            "prodigy",
            "suicide squad",
            "taylor swift",
            "melania trump",
            "go",
            "happy birthday",
            "wonder woman",
            "solitaire",
            "carrie fisher",
            "tis the season",
            "ariana grande",
            "strainer things",
            "town of salem",
            "selena gomes",
            "the walking dead",
            "black panther",
            "prince",
            "cat",
            "dog",
            "monkey",
            "bored",
            "angry",
            "flirting",
            "hi",
            "hungry",
            "tired",
            "no",
            "sad",
            "happy",
            "love",
            "banana",
            "skeleton",
            "oh really",
            "Supernatural",
            "joker",
            "horse",
            "fat",
            "sleepy",
            "crazy"));
}