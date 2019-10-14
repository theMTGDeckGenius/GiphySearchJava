
package com.themtgdeckgenius.giphysearchjava.networking.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OriginalStill implements Parcelable
{

    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("width")
    @Expose
    private String width;
    public final static Parcelable.Creator<OriginalStill> CREATOR = new Creator<OriginalStill>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OriginalStill createFromParcel(Parcel in) {
            return new OriginalStill(in);
        }

        public OriginalStill[] newArray(int size) {
            return (new OriginalStill[size]);
        }

    }
    ;

    protected OriginalStill(Parcel in) {
        this.height = ((String) in.readValue((String.class.getClassLoader())));
        this.size = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.width = ((String) in.readValue((String.class.getClassLoader())));
    }

    public OriginalStill() {
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(height);
        dest.writeValue(size);
        dest.writeValue(url);
        dest.writeValue(width);
    }

    public int describeContents() {
        return  0;
    }

}
