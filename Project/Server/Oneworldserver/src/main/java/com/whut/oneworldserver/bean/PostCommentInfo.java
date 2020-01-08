package com.whut.oneworldserver.bean;

public class PostCommentInfo {
    private int commentNum;
    private String userName;
    private int postNum;
    private String comment;

    public PostCommentInfo(int commentNum, String userName, int postNum, String comment) {
        this.commentNum = commentNum;
        this.userName = userName;
        this.postNum = postNum;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "PostCommentInfo{" +
                "commentNum=" + commentNum +
                ", userName='" + userName + '\'' +
                ", postNum=" + postNum +
                ", comment='" + comment + '\'' +
                '}';
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPostNum() {
        return postNum;
    }

    public void setPostNum(int postNum) {
        this.postNum = postNum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}


