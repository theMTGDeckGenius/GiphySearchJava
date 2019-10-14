
package com.themtgdeckgenius.giphysearchjava.networking.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("bitly_gif_url")
    @Expose
    private String bitlyGifUrl;
    @SerializedName("bitly_url")
    @Expose
    private String bitlyUrl;
    @SerializedName("embed_url")
    @Expose
    private String embedUrl;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("content_url")
    @Expose
    private String contentUrl;
    @SerializedName("source_tld")
    @Expose
    private String sourceTld;
    @SerializedName("source_post_url")
    @Expose
    private String sourcePostUrl;
    @SerializedName("is_sticker")
    @Expose
    private Integer isSticker;
    @SerializedName("import_datetime")
    @Expose
    private String importDatetime;
    @SerializedName("trending_datetime")
    @Expose
    private String trendingDatetime;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("analytics")
    @Expose
    private Analytics analytics;
    private final static long serialVersionUID = -196790089801451753L;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("image_original_url")
    @Expose
    private String imageOriginalUrl;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("image_mp4_url")
    @Expose
    private String imageMp4Url;
    @SerializedName("image_frames")
    @Expose
    private String imageFrames;
    @SerializedName("image_width")
    @Expose
    private String imageWidth;
    @SerializedName("image_height")
    @Expose
    private String imageHeight;
    @SerializedName("fixed_height_downsampled_url")
    @Expose
    private String fixedHeightDownsampledUrl;
    @SerializedName("fixed_height_downsampled_width")
    @Expose
    private String fixedHeightDownsampledWidth;
    @SerializedName("fixed_height_downsampled_height")
    @Expose
    private String fixedHeightDownsampledHeight;
    @SerializedName("fixed_width_downsampled_url")
    @Expose
    private String fixedWidthDownsampledUrl;
    @SerializedName("fixed_width_downsampled_width")
    @Expose
    private String fixedWidthDownsampledWidth;
    @SerializedName("fixed_width_downsampled_height")
    @Expose
    private String fixedWidthDownsampledHeight;
    @SerializedName("fixed_height_small_url")
    @Expose
    private String fixedHeightSmallUrl;
    @SerializedName("fixed_height_small_still_url")
    @Expose
    private String fixedHeightSmallStillUrl;
    @SerializedName("fixed_height_small_width")
    @Expose
    private String fixedHeightSmallWidth;
    @SerializedName("fixed_height_small_height")
    @Expose
    private String fixedHeightSmallHeight;
    @SerializedName("fixed_width_small_url")
    @Expose
    private String fixedWidthSmallUrl;
    @SerializedName("fixed_width_small_still_url")
    @Expose
    private String fixedWidthSmallStillUrl;
    @SerializedName("fixed_width_small_width")
    @Expose
    private String fixedWidthSmallWidth;
    @SerializedName("fixed_width_small_height")
    @Expose
    private String fixedWidthSmallHeight;
    @SerializedName("caption")
    @Expose
    private String caption;
    public final static Parcelable.Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
    ;

    protected Data(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.slug = ((String) in.readValue((String.class.getClassLoader())));
        this.bitlyGifUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.bitlyUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.embedUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.source = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.contentUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.sourceTld = ((String) in.readValue((String.class.getClassLoader())));
        this.sourcePostUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.isSticker = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.importDatetime = ((String) in.readValue((String.class.getClassLoader())));
        this.trendingDatetime = ((String) in.readValue((String.class.getClassLoader())));
        this.images = ((Images) in.readValue((Images.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
        this.imageOriginalUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.imageUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.imageMp4Url = ((String) in.readValue((String.class.getClassLoader())));
        this.imageFrames = ((String) in.readValue((String.class.getClassLoader())));
        this.imageWidth = ((String) in.readValue((String.class.getClassLoader())));
        this.imageHeight = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedHeightDownsampledUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedHeightDownsampledWidth = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedHeightDownsampledHeight = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedWidthDownsampledUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedWidthDownsampledWidth = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedWidthDownsampledHeight = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedHeightSmallUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedHeightSmallStillUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedHeightSmallWidth = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedHeightSmallHeight = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedWidthSmallUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedWidthSmallStillUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedWidthSmallWidth = ((String) in.readValue((String.class.getClassLoader())));
        this.fixedWidthSmallHeight = ((String) in.readValue((String.class.getClassLoader())));
        this.caption = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Data() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBitlyGifUrl() {
        return bitlyGifUrl;
    }

    public void setBitlyGifUrl(String bitlyGifUrl) {
        this.bitlyGifUrl = bitlyGifUrl;
    }

    public String getBitlyUrl() {
        return bitlyUrl;
    }

    public void setBitlyUrl(String bitlyUrl) {
        this.bitlyUrl = bitlyUrl;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getSourceTld() {
        return sourceTld;
    }

    public void setSourceTld(String sourceTld) {
        this.sourceTld = sourceTld;
    }

    public String getSourcePostUrl() {
        return sourcePostUrl;
    }

    public void setSourcePostUrl(String sourcePostUrl) {
        this.sourcePostUrl = sourcePostUrl;
    }

    public Integer getIsSticker() {
        return isSticker;
    }

    public void setIsSticker(Integer isSticker) {
        this.isSticker = isSticker;
    }

    public String getImportDatetime() {
        return importDatetime;
    }

    public void setImportDatetime(String importDatetime) {
        this.importDatetime = importDatetime;
    }

    public String getTrendingDatetime() {
        return trendingDatetime;
    }

    public void setTrendingDatetime(String trendingDatetime) {
        this.trendingDatetime = trendingDatetime;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Analytics getAnalytics() {
        return analytics;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAnalytics(Analytics analytics) {
        this.analytics = analytics;
    }
    public String getImageOriginalUrl() {
        return imageOriginalUrl;
    }

    public void setImageOriginalUrl(String imageOriginalUrl) {
        this.imageOriginalUrl = imageOriginalUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageMp4Url() {
        return imageMp4Url;
    }

    public void setImageMp4Url(String imageMp4Url) {
        this.imageMp4Url = imageMp4Url;
    }

    public String getImageFrames() {
        return imageFrames;
    }

    public void setImageFrames(String imageFrames) {
        this.imageFrames = imageFrames;
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getFixedHeightDownsampledUrl() {
        return fixedHeightDownsampledUrl;
    }

    public void setFixedHeightDownsampledUrl(String fixedHeightDownsampledUrl) {
        this.fixedHeightDownsampledUrl = fixedHeightDownsampledUrl;
    }

    public String getFixedHeightDownsampledWidth() {
        return fixedHeightDownsampledWidth;
    }

    public void setFixedHeightDownsampledWidth(String fixedHeightDownsampledWidth) {
        this.fixedHeightDownsampledWidth = fixedHeightDownsampledWidth;
    }

    public String getFixedHeightDownsampledHeight() {
        return fixedHeightDownsampledHeight;
    }

    public void setFixedHeightDownsampledHeight(String fixedHeightDownsampledHeight) {
        this.fixedHeightDownsampledHeight = fixedHeightDownsampledHeight;
    }

    public String getFixedWidthDownsampledUrl() {
        return fixedWidthDownsampledUrl;
    }

    public void setFixedWidthDownsampledUrl(String fixedWidthDownsampledUrl) {
        this.fixedWidthDownsampledUrl = fixedWidthDownsampledUrl;
    }

    public String getFixedWidthDownsampledWidth() {
        return fixedWidthDownsampledWidth;
    }

    public void setFixedWidthDownsampledWidth(String fixedWidthDownsampledWidth) {
        this.fixedWidthDownsampledWidth = fixedWidthDownsampledWidth;
    }

    public String getFixedWidthDownsampledHeight() {
        return fixedWidthDownsampledHeight;
    }

    public void setFixedWidthDownsampledHeight(String fixedWidthDownsampledHeight) {
        this.fixedWidthDownsampledHeight = fixedWidthDownsampledHeight;
    }

    public String getFixedHeightSmallUrl() {
        return fixedHeightSmallUrl;
    }

    public void setFixedHeightSmallUrl(String fixedHeightSmallUrl) {
        this.fixedHeightSmallUrl = fixedHeightSmallUrl;
    }

    public String getFixedHeightSmallStillUrl() {
        return fixedHeightSmallStillUrl;
    }

    public void setFixedHeightSmallStillUrl(String fixedHeightSmallStillUrl) {
        this.fixedHeightSmallStillUrl = fixedHeightSmallStillUrl;
    }

    public String getFixedHeightSmallWidth() {
        return fixedHeightSmallWidth;
    }

    public void setFixedHeightSmallWidth(String fixedHeightSmallWidth) {
        this.fixedHeightSmallWidth = fixedHeightSmallWidth;
    }

    public String getFixedHeightSmallHeight() {
        return fixedHeightSmallHeight;
    }

    public void setFixedHeightSmallHeight(String fixedHeightSmallHeight) {
        this.fixedHeightSmallHeight = fixedHeightSmallHeight;
    }

    public String getFixedWidthSmallUrl() {
        return fixedWidthSmallUrl;
    }

    public void setFixedWidthSmallUrl(String fixedWidthSmallUrl) {
        this.fixedWidthSmallUrl = fixedWidthSmallUrl;
    }

    public String getFixedWidthSmallStillUrl() {
        return fixedWidthSmallStillUrl;
    }

    public void setFixedWidthSmallStillUrl(String fixedWidthSmallStillUrl) {
        this.fixedWidthSmallStillUrl = fixedWidthSmallStillUrl;
    }

    public String getFixedWidthSmallWidth() {
        return fixedWidthSmallWidth;
    }

    public void setFixedWidthSmallWidth(String fixedWidthSmallWidth) {
        this.fixedWidthSmallWidth = fixedWidthSmallWidth;
    }

    public String getFixedWidthSmallHeight() {
        return fixedWidthSmallHeight;
    }

    public void setFixedWidthSmallHeight(String fixedWidthSmallHeight) {
        this.fixedWidthSmallHeight = fixedWidthSmallHeight;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(id);
        dest.writeValue(url);
        dest.writeValue(slug);
        dest.writeValue(bitlyGifUrl);
        dest.writeValue(bitlyUrl);
        dest.writeValue(embedUrl);
        dest.writeValue(username);
        dest.writeValue(source);
        dest.writeValue(title);
        dest.writeValue(contentUrl);
        dest.writeValue(sourceTld);
        dest.writeValue(sourcePostUrl);
        dest.writeValue(isSticker);
        dest.writeValue(importDatetime);
        dest.writeValue(trendingDatetime);
        dest.writeValue(images);
        dest.writeValue(user);
        dest.writeValue(imageOriginalUrl);
        dest.writeValue(imageUrl);
        dest.writeValue(imageMp4Url);
        dest.writeValue(imageFrames);
        dest.writeValue(imageWidth);
        dest.writeValue(imageHeight);
        dest.writeValue(fixedHeightDownsampledUrl);
        dest.writeValue(fixedHeightDownsampledWidth);
        dest.writeValue(fixedHeightDownsampledHeight);
        dest.writeValue(fixedWidthDownsampledUrl);
        dest.writeValue(fixedWidthDownsampledWidth);
        dest.writeValue(fixedWidthDownsampledHeight);
        dest.writeValue(fixedHeightSmallUrl);
        dest.writeValue(fixedHeightSmallStillUrl);
        dest.writeValue(fixedHeightSmallWidth);
        dest.writeValue(fixedHeightSmallHeight);
        dest.writeValue(fixedWidthSmallUrl);
        dest.writeValue(fixedWidthSmallStillUrl);
        dest.writeValue(fixedWidthSmallWidth);
        dest.writeValue(fixedWidthSmallHeight);
        dest.writeValue(caption);
    }

    public int describeContents() {
        return  0;
    }

}
