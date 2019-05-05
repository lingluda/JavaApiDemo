package com.example.demo.dao.ext;

import com.example.demo.dao.App;

import java.util.ArrayList;

public class ExtApp {
    private String title;
    private ArrayList<App> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<App> getList() {
        return list;
    }

    public void setList(ArrayList<App> list) {
        this.list = list;
    }
}
