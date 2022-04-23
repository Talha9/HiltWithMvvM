package com.gamess.hiltwithmvvm.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiModel {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("context")
    @Expose
    private Context context;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
