package com.application.testapplication.data.model.response.main;

import com.application.testapplication.data.model.response.sub.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserAccountResponse {

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("included")
    @Expose
    private List<Data> included = null;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<Data> getIncluded() {
        return included;
    }

    public void setIncluded(List<Data> included) {
        this.included = included;
    }

}
