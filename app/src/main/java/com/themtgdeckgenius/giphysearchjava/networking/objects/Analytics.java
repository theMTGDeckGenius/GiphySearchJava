
package com.themtgdeckgenius.giphysearchjava.networking.objects;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Analytics implements Serializable
{

    @SerializedName("onload")
    @Expose
    private Onload onload;
    @SerializedName("onclick")
    @Expose
    private Onclick onclick;
    @SerializedName("onsent")
    @Expose
    private Onsent onsent;
    private final static long serialVersionUID = 4264517363206516329L;

    public Onload getOnload() {
        return onload;
    }

    public void setOnload(Onload onload) {
        this.onload = onload;
    }

    public Onclick getOnclick() {
        return onclick;
    }

    public void setOnclick(Onclick onclick) {
        this.onclick = onclick;
    }

    public Onsent getOnsent() {
        return onsent;
    }

    public void setOnsent(Onsent onsent) {
        this.onsent = onsent;
    }

}
