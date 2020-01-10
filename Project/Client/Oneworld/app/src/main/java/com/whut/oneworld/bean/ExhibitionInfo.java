package com.whut.oneworld.bean;

public class ExhibitionInfo {
    private int exhibitionNum;
    private String title;
    private String description;
    private String imageUrl;
    private int popularity;

    public ExhibitionInfo(int exhibitionNum, String title, String description, String imageUrl, int popularity) {
        this.exhibitionNum = exhibitionNum;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.popularity = popularity;
    }

    public ExhibitionInfo() {
    }

    public int getExhibitionNum() {
        return exhibitionNum;
    }

    public void setExhibitionNum(int exhibitionNum) {
        this.exhibitionNum = exhibitionNum;
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
                "exhibition=" + exhibitionNum +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", popularity=" + popularity +
                '}';
    }
}
