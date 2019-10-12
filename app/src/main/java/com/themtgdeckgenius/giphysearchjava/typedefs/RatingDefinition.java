package com.themtgdeckgenius.giphysearchjava.typedefs;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.StringDef;



public class RatingDefinition {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({RATING_Y,RATING_G,RATING_PG,RATING_PG_13,RATING_R})
    public @interface RatingType{}

    public static final String RATING_Y = "Y";
    public static final String RATING_G = "G";
    public static final String RATING_PG = "PG";
    public static final String RATING_PG_13 = "PG-13";
    public static final String RATING_R = "R";

    @RatingType
    private String mRating;

    @RatingType
    public String getRating(){
        return mRating;
    };

    public void setRating(@RatingType String rating){
        mRating = rating;
    }

}
