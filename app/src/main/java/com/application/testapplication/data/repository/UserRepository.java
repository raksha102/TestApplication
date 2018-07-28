package com.application.testapplication.data.repository;

import com.application.testapplication.ui.model.data.UserAccountModel;

import io.reactivex.Flowable;

public interface UserRepository {

    Flowable<UserAccountModel> getUserDetail();
}
