
package com.themtgdeckgenius.giphysearchjava.networking.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandomObject implements Parcelable
{

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    public final static Parcelable.Creator<RandomObject> CREATOR = new Creator<RandomObject>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RandomObject createFromParcel(Parcel in) {
            return new RandomObject(in);
        }

        public RandomObject[] newArray(int size) {
            return (new RandomObject[size]);
        }

    }
    ;

    protected RandomObject(Parcel in) {
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
        this.meta = ((Meta) in.readValue((Meta.class.getClassLoader())));
    }

    public RandomObject() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(data);
        dest.writeValue(meta);
    }

    public int describeContents() {
        return  0;
    }

}
