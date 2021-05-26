package com.mvvm.lib.util;

import android.util.Log;

import androidx.databinding.library.BuildConfig;


public class LogUtil {

    private static final String TAG = "LogUtil";
    public final static int logSubLenth = 3000;

    public static void d(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }


    public static void i(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, message);
        }
    }


    public static void w(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.w(tag, message);
        }
    }


    public static void e(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message);
        }
    }

    public static void show(String content) {
        if (BuildConfig.DEBUG) {
            logSplit(TAG, content, 1);
        }
    }

    public static void logSplit(String explain, String message, int i) {
        //TODO 添加非debug下不打印日志
        //        if (!BuildConfig.DEBUG) return;
        if (i > 10) return;
        if (message.length() <= logSubLenth) {
            Log.i(explain, explain + i + "：     " + message);
            return;
        }

        String msg1 = message.substring(0, logSubLenth);
        Log.i(explain, explain + i + "：     " + msg1);
        String msg2 = message.substring(logSubLenth);
        logSplit(explain, msg2, ++i);
    }
}
