
package com.themtgdeckgenius.giphysearchjava.networking.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Original implements Parcelable
{

    @SerializedName("frames")
    @Expose
    private String frames;
    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("mp4")
    @Expose
    private String mp4;
    @SerializedName("mp4_size")
    @Expose
    private String mp4Size;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("webp")
    @Expose
    private String webp;
    @SerializedName("webp_size")
    @Expose
    private String webpSize;
    @SerializedName("width")
    @Expose
    private String width;
    public final static Parcelable.Creator<Original> CREATOR = new Creator<Original>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Original createFromParcel(Parcel in) {
            return new Original(in);
        }

        public Original[] newArray(int size) {
            return (new Original[size]);
        }

    }
    ;

    protected Original(Parcel in) {
        this.frames = ((String) in.readValue((String.class.getClassLoader())));
        this.hash = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((String) in.readValue((String.class.getClassLoader())));
        this.mp4 = ((String) in.readValue((String.class.getClassLoader())));
        this.mp4Size = ((String) in.readValue((String.class.getClassLoader())));
        this.size = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.webp = ((String) in.readValue((String.class.getClassLoader())));
        this.webpSize = ((String) in.readValue((String.class.getClassLoader())));
        this.width = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Original() {
    }

    public String getFrames() {
        return frames;
    }

    public void setFrames(String frames) {
        this.frames = frames;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
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

    public String getWebp() {
        return webp;
    }

    public void setWebp(String webp) {
        this.webp = webp;
    }

    public String getWebpSize() {
        return webpSize;
    }

    public void setWebpSize(String webpSize) {
        this.webpSize = webpSize;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(frames);
        dest.writeValue(hash);
        dest.writeValue(height);
        dest.writeValue(mp4);
        dest.writeValue(mp4Size);
        dest.writeValue(size);
        dest.writeValue(url);
        dest.writeValue(webp);
        dest.writeValue(webpSize);
        dest.writeValue(width);
    }

    public int describeContents() {
        return  0;
    }

}
