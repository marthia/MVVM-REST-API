package com.learntodroid.mvvmrestapi.models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Volume {

    public static DiffUtil.ItemCallback<Volume> DIFF_UTIL = new DiffUtil.ItemCallback<Volume>() {
        @Override
        public boolean areItemsTheSame(@NonNull Volume oldItem, @NonNull Volume newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Volume oldItem, @NonNull Volume newItem) {
            return oldItem.getId().equals(newItem.getId());
        }
    };
    @SerializedName("volumeInfo")
    @Expose
    VolumeInfo volumeInfo;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("selfLink")
    @Expose
    private String selfLink;

    public String getKind() {
        return kind;
    }

    public String getId() {
        return id;
    }

    public String getEtag() {
        return etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }
}
