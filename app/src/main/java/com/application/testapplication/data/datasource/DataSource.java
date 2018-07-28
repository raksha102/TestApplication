package com.application.testapplication.data.datasource;

import com.application.testapplication.data.model.response.main.UserAccountResponse;
import com.application.testapplication.ui.model.data.UserAccountModel;

import io.reactivex.Flowable;

public interface DataSource {

    Flowable<UserAccountResponse> getUserDetail();
}
