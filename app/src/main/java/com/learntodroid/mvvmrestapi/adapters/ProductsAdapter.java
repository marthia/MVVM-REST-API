package com.learntodroid.mvvmrestapi.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.learntodroid.mvvmrestapi.databinding.ListItemProductBinding;
import com.learntodroid.mvvmrestapi.models.Product;

public class ProductsAdapter extends ListAdapter<Product, ProductsAdapter.ViewHolder> {

    protected ProductsAdapter(){
        super(Product.DIFF_UTIL);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemProductBinding binding = ListItemProductBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product item = getItem(position);
        holder.bind(item);
        holder.itemView.setOnClickListener(holder);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ListItemProductBinding binding;

        public ViewHolder(@NonNull ListItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Product product) {
            binding.setItem(product);
            binding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {

        }
    }
}
