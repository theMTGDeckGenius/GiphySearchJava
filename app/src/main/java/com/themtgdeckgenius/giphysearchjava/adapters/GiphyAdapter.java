package com.themtgdeckgenius.giphysearchjava.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.themtgdeckgenius.giphysearchjava.R;
import com.themtgdeckgenius.giphysearchjava.listeners.EndOfListListener;
import com.themtgdeckgenius.giphysearchjava.networking.objects.Data;
import com.themtgdeckgenius.giphysearchjava.persistence.FavoriteRepository;
import com.themtgdeckgenius.giphysearchjava.persistence.tables.Favorite;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class GiphyAdapter extends RecyclerView.Adapter<GiphyAdapter.ViewHolder> {
    private List<Data> mGiphs;
    private List<Favorite> mFavorites;
    private Context mContext;
    EndOfListListener endOfListListener;

    public GiphyAdapter(List<Data> giphs, Context context, EndOfListListener listener) {
        this.mGiphs = giphs;
        this.mContext = context;
        this.endOfListListener = listener;
    }

    public GiphyAdapter(List<Favorite> giphs, Context context) {
        this.mFavorites = giphs;
        this.mContext = context;
        this.endOfListListener = null;
    }


    public void addGifs(List<Data> giphs) {
        this.mGiphs.addAll(giphs) ;
    }

    public void setEndOfListListener(EndOfListListener listener){
        this.endOfListListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.giphy_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final FavoriteRepository favoriteRepository = new FavoriteRepository(mContext);

        if (endOfListListener != null && position == mGiphs.size() - 1){
            endOfListListener.onEndReached(position);
        }

        holder.imageView.setImageDrawable(null);

        String currentUrl = "";

        if (mGiphs != null){
            currentUrl = mGiphs.get(position).getImages().getOriginal().getUrl();
        } else if(mFavorites != null){
            currentUrl = mFavorites.get(position).getGiphyUrl();
        }

        Glide.with(mContext)
                .asGif()
                .load(currentUrl.isEmpty() ? R.drawable.broken_link : currentUrl)
                .thumbnail(0.1f)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .centerCrop()
                .into(new CustomTarget<GifDrawable>() {
                    @Override
                    public void onResourceReady(@NonNull GifDrawable resource, @Nullable Transition<? super GifDrawable> transition) {
                        holder.imageView.setImageDrawable(resource);
                        resource.start();
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });

        if(favoriteRepository.checkIfPresent(currentUrl)){
            holder.favorite.setImageResource(R.drawable.ic_star_favorite);
        } else {
            holder.favorite.setImageResource(R.drawable.ic_star_border_favorite);
        }

        final String finalCurrentUrl = currentUrl;
        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(favoriteRepository.checkIfPresent(finalCurrentUrl)){
                    favoriteRepository.deleteTask(finalCurrentUrl);
                    holder.favorite.setImageResource(R.drawable.ic_star_border_favorite);
                    mFavorites.remove(position);
                    notifyDataSetChanged();
                } else {
                    favoriteRepository.insertTask(finalCurrentUrl);
                    holder.favorite.setImageResource(R.drawable.ic_star_favorite);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mGiphs != null){
            return mGiphs.size();
        } else if (mFavorites != null){
            return mFavorites.size();
        } else {
            return 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private ImageView favorite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gif_drawable);
            favorite = itemView.findViewById(R.id.favorite);
        }
    }
}
