package com.application.testapplication.data.model.mapper;

import com.application.testapplication.data.model.response.main.UserAccountResponse;
import com.application.testapplication.injection.scope.ApplicationScope;
import com.application.testapplication.ui.model.data.UserAccountModel;

import javax.inject.Inject;

@ApplicationScope
public class UserMapperImpl implements Mapper {

    @Inject
    public UserMapperImpl() {
    }

    @Override
    public UserAccountModel transform(UserAccountResponse response) {
        return new UserAccountModel(response);
    }
}
