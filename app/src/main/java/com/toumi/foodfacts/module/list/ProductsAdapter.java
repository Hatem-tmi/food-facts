package com.toumi.foodfacts.module.list;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toumi.foodfacts.R;
import com.toumi.foodfacts.data.model.Product;
import com.toumi.foodfacts.databinding.ItemProductBinding;

import java.util.List;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class ProductsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Product> products;
    private ProductItemClickListener itemClickListener;

    public ProductsAdapter(List<Product> products) {
        this.products = products;
    }

    public void setItemClickListener(ProductItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (!(holder instanceof ItemViewHolder)) {
            return;
        }

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.bind(products.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return products != null ? products.size() : 0;
    }

    public interface ProductItemClickListener {
        void onProductItemClicked(Product product);
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        private ItemProductBinding binding;

        ItemViewHolder(View rowView) {
            super(rowView);
            binding = DataBindingUtil.bind(rowView);
        }

        void bind(Product product, ProductItemClickListener listener) {
            binding.setProduct(product);
            binding.setItemClickListener(listener);
            binding.executePendingBindings();
        }
    }
}
