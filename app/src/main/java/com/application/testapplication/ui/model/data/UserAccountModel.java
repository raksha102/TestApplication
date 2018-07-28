package com.application.testapplication.ui.model.data;

import com.application.testapplication.data.model.response.main.UserAccountResponse;
import com.application.testapplication.data.model.response.sub.Data;

import java.util.HashMap;
import java.util.Map;

public class UserAccountModel {

    private Map<String, AccountAttributeModel> mUserData;

    public UserAccountModel(UserAccountResponse response) {
        if (response.getData() == null) return;
        mUserData = new HashMap<>();
        parseData(response.getData());
        if (response.getIncluded() == null) return;
        for (Data data : response.getIncluded()) {
            parseData(data);
        }
    }

    private void parseData(Data data) {
        mUserData.put(data.getType(), new AccountAttributeModel(data.getAttributes()));
    }

    public Map<String, AccountAttributeModel> getUserData() {
        return mUserData;
    }
}
