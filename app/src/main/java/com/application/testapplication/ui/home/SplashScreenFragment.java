package com.application.testapplication.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.testapplication.R;
import com.application.testapplication.databinding.FragmentSplashScreenBinding;
import com.application.testapplication.ui.base.BaseFragment;
import com.application.testapplication.ui.model.data.AppToolbar;

public class SplashScreenFragment extends BaseFragment {

    public static SplashScreenFragment newInstance() {
        return new SplashScreenFragment();
    }

    @Override
    protected View inflateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSplashScreenBinding binding = DataBindingUtil.inflate(inflater, getFragmentLayoutId(), container, false);
        return binding.getRoot();
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_splash_screen;
    }

    @Override
    protected void initViews(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getNavigator().launchSubscriptionScreen();
            }
        }, 3000);
    }

    @Override
    public AppToolbar getToolBarSetting() {
        return new AppToolbar.AppToolBarBuilder(false).build();
    }
}
