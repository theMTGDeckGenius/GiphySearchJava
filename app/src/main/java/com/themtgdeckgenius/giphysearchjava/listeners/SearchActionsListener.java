package com.themtgdeckgenius.giphysearchjava.listeners;

public interface SearchActionsListener {

    void onEndReached(int position);
    void showShareDialog(String url);
}
