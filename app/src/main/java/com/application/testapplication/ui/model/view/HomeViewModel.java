package com.application.testapplication.ui.model.view;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.application.testapplication.ui.model.data.UserAccountModel;
import com.application.testapplication.utils.DataParser;

import javax.inject.Inject;

public class HomeViewModel extends ViewModel {

    private final DataParser mDataParser;

    private MutableLiveData<UserAccountModel> mLiveData = new MutableLiveData<>();

    @Inject
    public HomeViewModel(DataParser dataParser) {
        mDataParser = dataParser;
    }

    public void getData() {
        mLiveData.setValue(mDataParser.getUserData());
    }

    public MutableLiveData<UserAccountModel> getLiveData() {
        return mLiveData;
    }
}
