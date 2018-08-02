package com.application.testapplication.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.testapplication.ui.base.navigator.AppNavigator;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment extends Fragment {

    @Inject
    AppNavigator mNavigator;

    protected abstract int getFragmentLayoutId();

    protected abstract void initViews(View view);

    protected View inflateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayoutId(), container, false);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        AndroidSupportInjection.inject(this);

        View view = inflateView(inflater, container, savedInstanceState);

        initViews(view);

        return view;
    }

    protected AppNavigator getNavigator() {
        return mNavigator;
    }

}
