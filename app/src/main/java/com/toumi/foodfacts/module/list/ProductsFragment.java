package com.toumi.foodfacts.module.list;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toumi.foodfacts.R;
import com.toumi.foodfacts.common.base.BaseFragment;
import com.toumi.foodfacts.data.model.Product;
import com.toumi.foodfacts.databinding.FragmentProductsBinding;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class ProductsFragment extends BaseFragment<ProductsViewModel> {

    private FragmentProductsBinding binding;

    private ProductsAdapter adapter;
    private List<Product> products = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_products, container, false);
        initBinding();
        initViews();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getViewModel().loadDataFromCache();
    }

    private void initBinding() {
        binding.setViewModel(getViewModel());

        getViewModel().isLoading.observe(this, this::toggleLoading);
        getViewModel().productsObservable.observe(this, data -> {
            if (data != null) {
                products.clear();
                products.addAll(data);
                adapter.notifyDataSetChanged();

                if (!products.isEmpty()) {
                    selectProductItem(products.get(0));
                }
            }

            binding.listMessageView.setVisibility(!products.isEmpty() ? View.GONE : View.VISIBLE);
            binding.recyclerView.setVisibility(!products.isEmpty() ? View.VISIBLE : View.GONE);
        });
    }

    private void initViews() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerDecoration = new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(activity, R.drawable.divider);
        if (drawable != null) {
            dividerDecoration.setDrawable(drawable);
        }
        binding.recyclerView.addItemDecoration(dividerDecoration);

        adapter = new ProductsAdapter(products);
        adapter.setItemClickListener(product -> {
            Timber.i("Product '%s' is clicked !", product.getName());

            selectProductItem(product);
        });
        binding.recyclerView.setAdapter(adapter);
    }

    private void selectProductItem(Product product) {
        if (products == null || product == null)
            return;

        for (Product p : products) {
            if (product.equals(p)) {
                p.setSelected(true);
                getViewModel().showProductDetails(p);
            } else {
                p.setSelected(false);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
