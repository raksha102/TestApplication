package com.application.testapplication.ui.model.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.application.testapplication.data.repository.UserRepository;
import com.application.testapplication.ui.model.data.UserAccountModel;
import com.application.testapplication.utils.Logger;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

public class HomeViewModel extends ViewModel {

    private final String TAG  = HomeViewModel.class.getSimpleName();

    private final UserRepository mRepository;

    private MutableLiveData<UserAccountModel> mLiveData = new MutableLiveData<>();

    @Inject
    public HomeViewModel(UserRepository repository) {
        mRepository = repository;
    }

    public void getData(){
        mRepository.getUserDetail()
                .firstElement().toSingle()
                .subscribeWith(new DisposableSingleObserver<UserAccountModel>() {
                    @Override
                    public void onSuccess(UserAccountModel userAccountModel) {
                        mLiveData.setValue(userAccountModel);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d(TAG, "getUserDetail : onError");
                    }
                });
    }

    public MutableLiveData<UserAccountModel> getLiveData() {
        return mLiveData;
    }
}
