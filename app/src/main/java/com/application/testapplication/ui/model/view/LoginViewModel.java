package com.application.testapplication.ui.model.view;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.application.testapplication.BR;
import com.application.testapplication.application.constants.AppConstants;
import com.application.testapplication.ui.base.navigator.AppNavigator;

import javax.inject.Inject;

public class LoginViewModel extends BaseObservable {

    private final AppNavigator mNavigator;
    private String loginId;
    private boolean error;

    @Inject
    public LoginViewModel(AppNavigator navigator) {
        mNavigator = navigator;
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

    public void setError(boolean error) {
        this.error = error;
        notifyPropertyChanged(BR.error);
    }

    public void onLoginButtonClick() {

        mNavigator.hideKeyBoard();

        if (TextUtils.isEmpty(loginId) || !TextUtils.equals(loginId, AppConstants.USER_LOGIN_ID)) {
            setError(true);
            return;
        }

        mNavigator.launchWelcomeScreen();
    }
}
