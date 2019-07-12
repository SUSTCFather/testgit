package com.example.githubdemo.model;

import java.util.ArrayList;
import java.util.List;

public class CommunityContent {
    private String name;
    private String level;
    private String headUrl;
    private List<String> contentPicUrls;
    private String text;
    private int type;



    public CommunityContent(int type){
        name = "蔡徐坤";
        level = "Lv7";
        headUrl = null;
        contentPicUrls = new ArrayList<>();
        text = "蔡徐坤打篮球";
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public List<String> getContentPicUrls() {
        return contentPicUrls;
    }

    public void setContentPicUrls(List<String> contentPicUrls) {
        this.contentPicUrls = contentPicUrls;
    }

    public void addContentPicUrls(String url){
        contentPicUrls.add(url);
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
