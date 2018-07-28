package com.application.testapplication.utils;


import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.application.testapplication.ui.model.data.AccountAttributeModel;

public class DataBindingUtil {

    @BindingAdapter("unlimitedText")
    public static void setUnlimitedText(TextView view, AccountAttributeModel data) {

        if (!data.isUnlimitedText() && !data.isUnlimitedIntText()) {
            view.setVisibility(View.GONE);
        }

        StringBuilder builder = new StringBuilder("Unlimited ");
        if (data.isUnlimitedText()) {
            builder.append("Local/National");
        }

        if (!TextUtils.isEmpty(builder.toString()) && data.isUnlimitedIntText()) {
            builder.append("/");
        }

        if (data.isUnlimitedIntText()) {
            builder.append("International");
        }

        builder.append(" Text");

        view.setText(builder.toString());
    }

    @BindingAdapter("unlimitedTalk")
    public static void setUnlimitedTalk(TextView view, AccountAttributeModel data) {

        if (!data.isUnlimitedTalk() && !data.isUnlimitedIntTalk()) {
            view.setVisibility(View.GONE);
        }

        StringBuilder builder = new StringBuilder("Unlimited ");
        if (data.isUnlimitedTalk()) {
            builder.append("Local/National");
        }

        if (!TextUtils.isEmpty(builder.toString()) && data.isUnlimitedIntTalk()) {
            builder.append("/");
        }

        if (data.isUnlimitedIntTalk()) {
            builder.append("International");
        }

        builder.append(" Talk");

        view.setText(builder.toString());
    }
}
