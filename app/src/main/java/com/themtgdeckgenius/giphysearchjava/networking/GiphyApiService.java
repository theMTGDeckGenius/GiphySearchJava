package com.themtgdeckgenius.giphysearchjava.networking;

import com.themtgdeckgenius.giphysearchjava.networking.objects.GiphyObject;
import com.themtgdeckgenius.giphysearchjava.typedefs.RatingDefinition;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GiphyApiService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.giphy.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

     GiphyApiService service = retrofit.create(GiphyApiService.class);

    @GET("v1/gifs/search")
    Call<GiphyObject> searchGiphy(@Query("api_key") String apiKey,
                                  @Query("q") String term,
                                  @Query("limit") int numberOfResponses,
                                  @Query("offset") int offset,
                                  @Query("rating") @RatingDefinition.RatingType String rating,
                                  @Query("lang") String lang);
}
