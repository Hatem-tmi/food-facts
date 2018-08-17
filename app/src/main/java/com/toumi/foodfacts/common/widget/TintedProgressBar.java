package com.toumi.foodfacts.common.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;

import com.toumi.foodfacts.R;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class TintedProgressBar extends ProgressBar {

    public TintedProgressBar(Context context) {
        super(context);
        init();
    }

    public TintedProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TintedProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        getIndeterminateDrawable().setColorFilter(getAccentColor(), PorterDuff.Mode.SRC_IN);
    }

    @ColorInt
    private int getAccentColor() {
        final TypedValue value = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.colorAccent, value, true);
        return value.data;
    }
}