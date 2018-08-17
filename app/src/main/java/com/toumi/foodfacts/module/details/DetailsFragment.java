package com.toumi.foodfacts.module.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toumi.foodfacts.R;
import com.toumi.foodfacts.common.base.BaseFragment;
import com.toumi.foodfacts.databinding.FragmentProductDetailsBinding;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class DetailsFragment extends BaseFragment<DetailsViewModel> {

    private FragmentProductDetailsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_details, container, false);
        initBinding();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initBinding() {
        binding.setViewModel(getViewModel());

        getViewModel().isLoading.observe(this, this::toggleLoading);
        getViewModel().productObservable.observe(this, product -> {
            if (product != null) {
                binding.setProduct(product);
            }
        });
    }
}
