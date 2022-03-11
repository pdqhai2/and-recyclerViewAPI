package com.example.recylerviewapi;

import com.google.gson.annotations.SerializedName;

public class Article {

    private String title;
    private String pub_day;
    private String link;

    public Article(String title, String pub_day, String link) {
        this.title = title;
        this.pub_day = pub_day;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getPub_day() {
        return pub_day;
    }

    public String getLink() {
        return link;
    }
}
