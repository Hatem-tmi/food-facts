package com.toumi.foodfacts.common.util;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.toumi.foodfacts.R;
import com.toumi.foodfacts.common.dagger.module.GlideApp;

import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class Databindings {

    @BindingAdapter("bind:manageTranslucentStatusBar")
    public static void manageTranslucentStatusBar(View view, boolean value) {
        if (value && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int statusBarHeight = Utils.getStatusBarHeight(view.getContext());
            view.getLayoutParams().height += statusBarHeight;
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + statusBarHeight, view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    @BindingAdapter({"selected"})
    public static void setSelected(View view, boolean isSelected) {
        view.setSelected(isSelected);
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();

        GlideApp.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }

    @BindingAdapter({"bind:date", "bind:formatter"})
    public static void setFormattedDate(TextView textView, long timestamp, String formatter) {
        textView.setText(Utils.timestampToDate(timestamp, formatter, Locale.US, TimeZone.getDefault()));
    }

    @BindingAdapter({"fromHtml"})
    public static void fromHtml(TextView textView, String text) {
        textView.setText(Utils.fromHtml(text));
    }
}
