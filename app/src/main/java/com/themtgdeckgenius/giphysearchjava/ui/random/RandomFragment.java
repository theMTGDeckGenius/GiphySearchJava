package com.themtgdeckgenius.giphysearchjava.ui.random;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.themtgdeckgenius.giphysearchjava.R;

public class RandomFragment extends Fragment {

    private RandomViewModel randomViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        randomViewModel =
                ViewModelProviders.of(this).get(RandomViewModel.class);
        View root = inflater.inflate(R.layout.fragment_random, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        randomViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}