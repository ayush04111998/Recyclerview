package com.example.recyclerviewlab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UserWrapper implements Serializable {

    @SerializedName("datalist")
    @Expose

    private List<RecyclerViewData> recyclerViewDataList;

    public List<RecyclerViewData> getRecyclerViewDataList() {
        return recyclerViewDataList;
    }

    public void setRecyclerViewDataList(List<RecyclerViewData> recyclerViewDataList) {
        this.recyclerViewDataList = recyclerViewDataList;
    }
}