package com.learntodroid.mvvmrestapi.models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class Product {
    private String productId;
    private String productName;

    public static DiffUtil.ItemCallback<Product> DIFF_UTIL = new DiffUtil.ItemCallback<Product>() {
        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.productId.equals(newItem.productId);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.productId.equals(newItem.productId);
        }
    };

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
