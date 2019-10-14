package com.themtgdeckgenius.giphysearchjava.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.themtgdeckgenius.giphysearchjava.BuildConfig;
import com.themtgdeckgenius.giphysearchjava.MainActivity;
import com.themtgdeckgenius.giphysearchjava.R;
import com.themtgdeckgenius.giphysearchjava.adapters.GiphyAdapter;
import com.themtgdeckgenius.giphysearchjava.listeners.SearchActionsListener;
import com.themtgdeckgenius.giphysearchjava.networking.GiphyApiService;
import com.themtgdeckgenius.giphysearchjava.networking.objects.Data;
import com.themtgdeckgenius.giphysearchjava.networking.objects.SearchObject;
import com.themtgdeckgenius.giphysearchjava.ui.dialogs.ActionsDialog;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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
                doGiphySearch(0);
            }
        });

        mSecondarySearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchTerm = mSecondarySearchBox.getText().toString();
                updateTitle();
                doGiphySearch(0);
            }
        });

        mGiphyAdapter = new GiphyAdapter(new ArrayList<Data>(), getContext(), new SearchActionsListener() {
            @Override
            public void onEndReached(int position) {
                doGiphySearch(position);
            }

            @Override
            public void showShareDialog(String url) {
                ActionsDialog dialog = new ActionsDialog(url);
                dialog.show(getFragmentManager(), "search_fragment_dialog");
            }
        });
        mGiphyDisplay.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mGiphyDisplay.setAdapter(mGiphyAdapter);
        return root;
    }

    private void updateTitle() {
        if (mSearchTerm.isEmpty()) {
            mTextViewTitle.setText(R.string.look_it_up);
        } else {
            mTextViewTitle.setText(getString(R.string.searching).replace("##TERM##", mSearchTerm));
        }
    }

    private void doGiphySearch(int offset) {
        GiphyApiService giphyApiService = GiphyApiService.service;
        Call<SearchObject> call = giphyApiService.searchGiphy(BuildConfig.GIPHY_API_KEY, mSearchTerm, 25, offset, ((MainActivity) getActivity()).getRating(), "en");
        call.enqueue(new Callback<SearchObject>() {
            @Override
            public void onResponse(Call<SearchObject> call, Response<SearchObject> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        mGiphyAdapter.addGifs(response.body().getData());
                        mGiphyAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchObject> call, Throwable t) {

            }
        });
    }
}