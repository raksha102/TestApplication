package com.application.testapplication.ui.model.view;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.application.testapplication.BR;
import com.application.testapplication.ui.base.navigator.AppNavigator;
import com.application.testapplication.utils.DataParser;

import javax.inject.Inject;

public class LoginViewModel extends BaseObservable {

    private final AppNavigator mNavigator;
    private final DataParser mDataParser;
    private String loginId;
    private boolean error;

    @Inject
    public LoginViewModel(AppNavigator navigator, DataParser dataParser) {
        mNavigator = navigator;
        mDataParser = dataParser;
    }

    @Bindable
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
        setError(false);
    }

    @Bindable
    public boolean isError() {
        return error;
    }

    private void setError(boolean error) {
        this.error = error;
        notifyPropertyChanged(BR.error);
    }

    public void onLoginButtonClick() {
        mNavigator.hideKeyBoard();
        if (TextUtils.equals(mDataParser.getMsnId(), loginId)) {
            mNavigator.launchWelcomeScreen();
        } else {
            setError(true);
        }
    }
}
