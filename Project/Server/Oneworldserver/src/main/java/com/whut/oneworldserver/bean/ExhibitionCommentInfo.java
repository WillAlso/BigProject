package com.whut.oneworldserver.bean;

public class ExhibitionCommentInfo {
    private int commentNum;
    private String userName;
    private int exhibitionNum;
    private String comment;

    public ExhibitionCommentInfo() {
    }

    public ExhibitionCommentInfo(int commentNum, String userName, int exhibitionNum, String comment) {
        this.commentNum = commentNum;
        this.userName = userName;
        this.exhibitionNum = exhibitionNum;
        this.comment = comment;
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

    public int getExhibitionNum() {
        return exhibitionNum;
    }

    public void setExhibitionNum(int exhibitionNum) {
        this.exhibitionNum = exhibitionNum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ExhibitionCommentInfo{" +
                "commentNum=" + commentNum +
                ", userName='" + userName + '\'' +
                ", exhibitionNum=" + exhibitionNum +
                ", comment='" + comment + '\'' +
                '}';
    }
}
