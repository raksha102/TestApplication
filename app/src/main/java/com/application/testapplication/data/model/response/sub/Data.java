package com.application.testapplication.data.model.response.sub;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    /*@SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("relationships")
    @Expose
    private Relationships relationships;*/

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Attributes getAttributes() {
        return attributes;
    }
}
