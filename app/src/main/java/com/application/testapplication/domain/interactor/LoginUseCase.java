package com.application.testapplication.domain.interactor;

import android.text.TextUtils;

import com.application.testapplication.application.constants.AppConstants;
import com.application.testapplication.domain.executor.PostExecutionThread;

import javax.inject.Inject;

import io.reactivex.Single;

public class LoginUseCase extends UseCase<Single<Boolean>, LoginUseCase.Params> {

    @Inject
    public LoginUseCase() {
        super(null);
    }

    @Override
    public Single<Boolean> execute(Params params) {
        boolean isValid = params.loginId != null
                && AppConstants.USER_LOGIN_ID.equals(params.loginId);
        return Single.just(isValid);
    }

    public static class Params {
        private String loginId;

        public Params(String loginId) {
            this.loginId = loginId;
        }
    }
}
