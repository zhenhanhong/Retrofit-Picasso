package com.example.zhenhanhong.retrofit.bean;

import java.util.ArrayList;

/**
 * Created by zhenhanhong on 2016/11/21.
 */

public class Article {
    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public Boolean getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(Boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public ArrayList getItems() {
        return items;
    }

    public void setItems(ArrayList items) {
        this.items = items;
    }

    private int total_count;
    private Boolean incomplete_results;
    private ArrayList items;
}
