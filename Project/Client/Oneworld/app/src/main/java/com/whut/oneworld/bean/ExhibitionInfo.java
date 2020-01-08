package com.whut.oneworld.bean;

public class ExhibitionInfo {
    private int postNum;
    private String title;
    private String description;
    private String imageUrl;
    private int popularity;

    public ExhibitionInfo(int postNum, String title, String description, String imageUrl, int popularity) {
        this.postNum = postNum;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.popularity = popularity;
    }

    public ExhibitionInfo() {
    }

    public int getPostNum() {
        return postNum;
    }

    public void setPostNum(int postNum) {
        this.postNum = postNum;
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

    @Override
    public String toString() {
        return "ExhibitionInfo{" +
                "postNum=" + postNum +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", popularity=" + popularity +
                '}';
    }
}
