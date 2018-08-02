package com.application.testapplication.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.testapplication.R;
import com.application.testapplication.databinding.FragmentLoginBinding;
import com.application.testapplication.ui.base.BaseFragment;
import com.application.testapplication.ui.model.view.LoginViewModel;

import javax.inject.Inject;

public class LoginFragment extends BaseFragment {

    @Inject
    LoginViewModel mViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected View inflateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentLoginBinding binder = DataBindingUtil.inflate(inflater, getFragmentLayoutId(), container, false);
        binder.setViewModel(mViewModel);
        return binder.getRoot();
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initViews(View view) {
    }
}
