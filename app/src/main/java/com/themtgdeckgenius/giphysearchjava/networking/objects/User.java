
package com.themtgdeckgenius.giphysearchjava.networking.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable
{

    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("banner_url")
    @Expose
    private String bannerUrl;
    @SerializedName("banner_image")
    @Expose
    private String bannerImage;
    @SerializedName("profile_url")
    @Expose
    private String profileUrl;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("is_verified")
    @Expose
    private Boolean isVerified;
    public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
            "unchecked"
        })
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
    ;

    protected User(Parcel in) {
        this.avatarUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.bannerUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.bannerImage = ((String) in.readValue((String.class.getClassLoader())));
        this.profileUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.displayName = ((String) in.readValue((String.class.getClassLoader())));
        this.isVerified = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public User() {
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(avatarUrl);
        dest.writeValue(bannerUrl);
        dest.writeValue(bannerImage);
        dest.writeValue(profileUrl);
        dest.writeValue(username);
        dest.writeValue(displayName);
        dest.writeValue(isVerified);
    }

    public int describeContents() {
        return  0;
    }

}
