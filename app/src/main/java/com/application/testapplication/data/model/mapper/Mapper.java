package com.application.testapplication.data.model.mapper;

import com.application.testapplication.data.model.response.main.UserAccountResponse;
import com.application.testapplication.ui.model.data.UserAccountModel;

public interface Mapper {

    UserAccountModel transform(UserAccountResponse response);
}
