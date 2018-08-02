package com.application.testapplication.ui.model.data;

import java.util.List;

public class UserAccountModel {

    private List<AccountAttributeModel> mData;

    public void setData(List<AccountAttributeModel> mData) {
        this.mData = mData;
    }

    public List<AccountAttributeModel> getData() {
        return mData;
    }
}
