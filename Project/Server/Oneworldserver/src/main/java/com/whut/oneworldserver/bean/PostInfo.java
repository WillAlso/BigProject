package com.whut.oneworldserver.bean;

import java.util.Date;

public class PostInfo {
    private int postNum;
    private String userId;
    private String title;
    private String content;
    private String imageUrl;
    private Date postDate;


    // 数据库中没有，新加“author”存放作者名
    private String author;


    public PostInfo(int postNum, String userId, String title, String content, String imageUrl, Date postDate, String author) {
        this.postNum = postNum;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.postDate = postDate;
        this.author = author;
    }

    @Override
    public String toString() {
        return "PostInfo{" +
                "postNum=" + postNum +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", postDate=" + postDate +
                ", author='" + author + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPostNum() {
        return postNum;
    }

    public void setPostNum(int postNum) {
        this.postNum = postNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}

