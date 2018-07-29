package com.application.testapplication.data.datasource;

import com.application.testapplication.application.MIVIApplication;
import com.application.testapplication.data.model.response.main.UserAccountResponse;
import com.application.testapplication.injection.scope.ApplicationScope;
import com.application.testapplication.utils.FileUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import io.reactivex.Flowable;

@ApplicationScope
public class DataSourceImpl implements DataSource {

    @Inject
    public DataSourceImpl() {
    }

    @Override
    public Flowable<UserAccountResponse> getUserDetail() {

        UserAccountResponse response = null;
        try {
            InputStream inputStream =
                    MIVIApplication.getApplicationInstance().getAssets().open("collection.json");
            String json = FileUtil.readFromFle(inputStream);
            response = new Gson().fromJson(json, UserAccountResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException pe) {
            pe.printStackTrace();
        }
        return Flowable.just(response);
    }
}
