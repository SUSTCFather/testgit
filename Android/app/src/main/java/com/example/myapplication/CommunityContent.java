package com.example.myapplication;

public class CommunityContent {
    private String name;
    private String level;
    private String headUrl;
    private String contentPicUrl;
    private String text;

    public CommunityContent(){
        name = "蔡徐坤";
        level = "Lv7";
        headUrl = null;
        contentPicUrl = null;
        text = "蔡徐坤打篮球";
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

    public String getContentPicUrl() {
        return contentPicUrl;
    }

    public void setContentPicUrl(String contentPicUrl) {
        this.contentPicUrl = contentPicUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
