package com.themtgdeckgenius.giphysearchjava.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.themtgdeckgenius.giphysearchjava.BuildConfig;
import com.themtgdeckgenius.giphysearchjava.R;
import com.themtgdeckgenius.giphysearchjava.adapters.GiphyAdapter;
import com.themtgdeckgenius.giphysearchjava.networking.GiphyApiService;
import com.themtgdeckgenius.giphysearchjava.networking.objects.Data;
import com.themtgdeckgenius.giphysearchjava.networking.objects.GiphyObject;
import com.themtgdeckgenius.giphysearchjava.typedefs.RatingDefinition;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {
    private TextView mTextViewTitle;
    private EditText mPrimarySearchBox;
    private EditText mSecondarySearchBox;
    private Button mPrimarySearchButton;
    private Button mSecondarySearchButton;
    private View mPrimaryGroup;
    private View mSecondaryGroup;
    private RecyclerView mGiphyDisplay;

    private LinearLayoutManager mLinearLayoutManager;
    private GiphyAdapter mGiphyAdapter;

    private String mSearchTerm;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        mTextViewTitle = root.findViewById(R.id.text_search_title);
        mPrimarySearchBox = root.findViewById(R.id.editText_search_term_primary);
        mSecondarySearchBox = root.findViewById(R.id.editText_search_term_secondary);
        mPrimarySearchButton = root.findViewById(R.id.button_search_primary);
        mSecondarySearchButton = root.findViewById(R.id.button_search_secondary);
        mPrimaryGroup = root.findViewById(R.id.primary_search_input);
        mSecondaryGroup = root.findViewById(R.id.secondary_search_input);
        mGiphyDisplay = root.findViewById(R.id.recycler_view_search);

        mPrimarySearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchTerm = mPrimarySearchBox.getText().toString();
                updateTitle();
                mSecondarySearchBox.setText(mSearchTerm);
                mPrimaryGroup.setVisibility(View.GONE);
                mSecondaryGroup.setVisibility(View.VISIBLE);
                beginSearch(mSearchTerm);
            }
        });
        mSecondarySearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchTerm = mSecondarySearchBox.getText().toString();
                updateTitle();
                beginSearch(mSearchTerm);
            }
        });

        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mGiphyAdapter = new GiphyAdapter(new ArrayList<Data>(), getContext());
        mGiphyDisplay.setLayoutManager(mLinearLayoutManager);
        mGiphyDisplay.setAdapter(mGiphyAdapter);
        return root;
    }

    private void updateTitle(){
        if(mSearchTerm.isEmpty()){
            mTextViewTitle.setText(getString(R.string.searching).replace("##TERM##", mSearchTerm));
        } else {
            mTextViewTitle.setText(R.string.look_it_up);
        }
    }

    private void beginSearch(String string) {
        GiphyApiService giphyApiService = GiphyApiService.service;
        RatingDefinition type = new RatingDefinition();
        type.setRating(RatingDefinition.RATING_G);
        Call<GiphyObject> call = giphyApiService.searchGiphy(BuildConfig.GIPHY_API_KEY, string, 25, 0, RatingDefinition.RATING_G, "en");
        call.enqueue(new Callback<GiphyObject>() {
            @Override
            public void onResponse(Call<GiphyObject> call, Response<GiphyObject> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        mGiphyAdapter.updateGiphs(response.body().getData());
                        mGiphyAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<GiphyObject> call, Throwable t) {

            }
        });
    }
}