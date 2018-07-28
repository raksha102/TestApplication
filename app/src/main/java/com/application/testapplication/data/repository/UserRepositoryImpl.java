package com.application.testapplication.data.repository;

import com.application.testapplication.data.datasource.DataSource;
import com.application.testapplication.data.model.mapper.Mapper;
import com.application.testapplication.injection.scope.ApplicationScope;
import com.application.testapplication.ui.model.data.UserAccountModel;

import javax.inject.Inject;

import io.reactivex.Flowable;

@ApplicationScope
public class UserRepositoryImpl implements UserRepository {

    private final DataSource mDataSource;
    private final Mapper mMapper;

    @Inject
    public UserRepositoryImpl(DataSource dataSource, Mapper mapper) {
        mDataSource = dataSource;
        mMapper = mapper;
    }

    @Override
    public Flowable<UserAccountModel> getUserDetail() {
        return mDataSource.getUserDetail()
                .flatMap(response -> Flowable.just(mMapper.transform(response)));
    }
}
