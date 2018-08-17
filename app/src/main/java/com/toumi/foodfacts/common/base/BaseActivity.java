package com.toumi.foodfacts.common.base;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toumi.foodfacts.R;
import com.toumi.foodfacts.common.util.ClassUtils;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {

    private T viewModel;
    private ViewGroup container;
    private View loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(ClassUtils.getTypeParameterClass(getClass(), 0));
        if (viewModel != null)
            viewModel.onCreated();

        initLoading();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (viewModel != null)
            viewModel.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (viewModel != null)
            viewModel.onResume();
    }

    @Override
    protected void onPause() {
        if (viewModel != null)
            viewModel.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        if (viewModel != null)
            viewModel.onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (viewModel != null)
            viewModel.onDestroy();
        super.onDestroy();
    }

    protected T getViewModel() {
        return viewModel;
    }

    private void initLoading() {
        container = findViewById(android.R.id.content);
        loading = LayoutInflater.from(this).inflate(R.layout.layout_loading, container, false);
        loading.setOnTouchListener((v, event) -> true);
    }

    public void toggleLoading(boolean show) {
        if (show) {
            container.removeView(loading);
            container.addView(loading);
        } else {
            container.removeView(loading);
        }
    }
}
