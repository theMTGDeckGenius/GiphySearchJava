package com.themtgdeckgenius.giphysearchjava.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.themtgdeckgenius.giphysearchjava.R;
import com.themtgdeckgenius.giphysearchjava.networking.objects.Data;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class GiphyAdapter extends RecyclerView.Adapter<GiphyAdapter.ViewHolder> {
    private List<Data> mGiphs;
    private Context mContext;

    public GiphyAdapter(List<Data> giphs, Context context) {
        this.mGiphs = giphs;
        this.mContext = context;
    }

    public void updateGiphs(List<Data> giphs){
        this.mGiphs = giphs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView v = (ImageView) LayoutInflater.from(parent.getContext()).inflate(R.layout.giphy_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        ImageView imageView = holder.imageView;
        String currentUrl = mGiphs.get(position).getUrl();

        Glide.with(mContext)
                .load(currentUrl)
                .thumbnail(0.1f)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .centerCrop()
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return mGiphs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gif_drawable);
        }
    }
}
