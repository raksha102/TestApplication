package com.application.testapplication.ui.model.view;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.application.testapplication.BR;
import com.application.testapplication.domain.interactor.LoginUseCase;
import com.application.testapplication.ui.base.navigator.AppNavigator;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

public class LoginViewModel extends BaseObservable {

    private final AppNavigator mNavigator;
    private final LoginUseCase mLoginUseCase;
    private String loginId;
    private boolean error;

    @Inject
    public LoginViewModel(AppNavigator navigator, LoginUseCase loginUseCase) {
        mNavigator = navigator;
        mLoginUseCase = loginUseCase;
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
        mLoginUseCase.execute(new LoginUseCase.Params(loginId))
                .subscribeWith(new DisposableSingleObserver<Boolean>() {
                    @Override
                    public void onSuccess(Boolean success) {
                        if (success) {
                            mNavigator.launchWelcomeScreen();
                        } else {
                            setError(true);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        setError(true);
                    }
                });
    }
}
