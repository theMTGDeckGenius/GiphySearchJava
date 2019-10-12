
package com.themtgdeckgenius.giphysearchjava.networking.objects;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Onload implements Serializable
{

    @SerializedName("url")
    @Expose
    private String url;
    private final static long serialVersionUID = -8513170304560480040L;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
