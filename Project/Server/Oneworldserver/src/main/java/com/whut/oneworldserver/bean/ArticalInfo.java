package com.whut.oneworldserver.bean;

import java.util.Date;

public class ArticalInfo {
    private int articalNum;
    private String author;
    private String title;
    private String description;
    private String articalUrl;
    private String imageUrl;
    private int popularity;
    private Date pubDate;

    public ArticalInfo() {
    }

    public ArticalInfo(int articalNum, String author, String title, String description, String articalUrl, String imageUrl, int popularity, Date pubDate) {
        this.articalNum = articalNum;
        this.author = author;
        this.title = title;
        this.description = description;
        this.articalUrl = articalUrl;
        this.imageUrl = imageUrl;
        this.popularity = popularity;
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "ArticalInfo{" +
                "articalNum=" + articalNum +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", articalUrl='" + articalUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", popularity=" + popularity +
                ", pubDate=" + pubDate +
                '}';
    }

    public int getArticalNum() {
        return articalNum;
    }

    public void setArticalNum(int articalNum) {
        this.articalNum = articalNum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArticalUrl() {
        return articalUrl;
    }

    public void setArticalUrl(String articalUrl) {
        this.articalUrl = articalUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
}

