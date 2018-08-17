package com.toumi.foodfacts.common.base;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.toumi.foodfacts.common.util.ClassUtils;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public abstract class BaseFragment<T extends BaseViewModel> extends Fragment {

    private T viewModel;
    protected BaseActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        viewModel = ViewModelProviders.of(this).get(ClassUtils.getTypeParameterClass(getClass(), 0));
        activity = (BaseActivity) context;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (viewModel != null)
            viewModel.onCreated();
    }

    @Override
    public void onResume() {
        if (viewModel != null)
            viewModel.onResume();
        super.onResume();
    }

    @Override
    public void onPause() {
        if (viewModel != null)
            viewModel.onPause();
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        if (viewModel != null)
            viewModel.onDestroy();
        super.onDestroyView();
    }

    protected T getViewModel() {
        return viewModel;
    }

    protected void toggleLoading(boolean show) {
        if (isAdded()) {
            activity.toggleLoading(show);
        }
    }
}
