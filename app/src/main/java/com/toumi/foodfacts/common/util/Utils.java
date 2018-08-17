package com.toumi.foodfacts.common.util;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class Utils {

    /**
     * Returns the height of the status bar
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * Get stringDate from timestamp
     *
     * @param timestamp
     * @param templateFormatter
     * @param locale
     * @param timeZone
     * @return
     */
    public static String timestampToDate(long timestamp, String templateFormatter, Locale locale, TimeZone timeZone) {
        SimpleDateFormat formatter = new SimpleDateFormat(templateFormatter, locale);
        formatter.setTimeZone(timeZone);
        Date date = new Date(timestamp);

        // convert timestamp (seconds) to milliseconds
        return formatter.format(date);
    }

    /**
     * Get text from html
     *
     * @param text
     */
    public static Spanned fromHtml(String text) {
        if (text == null)
            return null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(text);
        }
    }
}
