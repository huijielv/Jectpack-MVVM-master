package com.mvvm.lib.util;

import android.content.Context;

import java.util.Locale;


public class LanguageUtil {
    public static boolean isZh(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        if (locale.getCountry().equals("CN"))
            return true;
        else
            return false;
    }
}
