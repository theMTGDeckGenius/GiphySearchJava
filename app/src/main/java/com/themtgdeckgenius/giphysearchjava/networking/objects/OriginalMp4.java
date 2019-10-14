
package com.themtgdeckgenius.giphysearchjava.networking.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OriginalMp4 implements Parcelable
{

    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("mp4")
    @Expose
    private String mp4;
    @SerializedName("mp4_size")
    @Expose
    private String mp4Size;
    @SerializedName("width")
    @Expose
    private String width;
    public final static Parcelable.Creator<OriginalMp4> CREATOR = new Creator<OriginalMp4>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OriginalMp4 createFromParcel(Parcel in) {
            return new OriginalMp4(in);
        }

        public OriginalMp4 [] newArray(int size) {
            return (new OriginalMp4[size]);
        }

    }
    ;

    protected OriginalMp4(Parcel in) {
        this.height = ((String) in.readValue((String.class.getClassLoader())));
        this.mp4 = ((String) in.readValue((String.class.getClassLoader())));
        this.mp4Size = ((String) in.readValue((String.class.getClassLoader())));
        this.width = ((String) in.readValue((String.class.getClassLoader())));
    }

    public OriginalMp4() {
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMp4() {
        return mp4;
    }

    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    public String getMp4Size() {
        return mp4Size;
    }

    public void setMp4Size(String mp4Size) {
        this.mp4Size = mp4Size;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(height);
        dest.writeValue(mp4);
        dest.writeValue(mp4Size);
        dest.writeValue(width);
    }

    public int describeContents() {
        return  0;
    }

}
