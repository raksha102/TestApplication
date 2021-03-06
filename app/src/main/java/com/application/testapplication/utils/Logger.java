/*
 *  Copyright © 2018, Cognizant Technology Solutions.
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package com.application.testapplication.utils;

import android.util.Log;

import com.application.testapplication.BuildConfig;

public class Logger {

    private static boolean isDebug() {
        Log.i("DEBUG Enabled", "" + BuildConfig.DEBUG);
        return BuildConfig.DEBUG;
    }

    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug()) {
            Log.e(tag, msg);
        }
    }

    public static void e(String tag, String msg, Throwable e) {
        if (isDebug()) {
            Log.e(tag, msg, e);
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug()) {
            Log.d(tag, msg);
        }
    }

    public static void d(String tag, String msg, Throwable e) {
        if (isDebug()) {
            Log.d(tag, msg, e);
        }
    }

    public static void v(String tag, String msg) {
        if (isDebug()) {
            Log.v(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isDebug()) {
            Log.w(tag, msg);
        }
    }

    public static void w(String tag, String msg, Throwable e) {
        if (isDebug()) {
            Log.w(tag, msg, e);
        }
    }
}