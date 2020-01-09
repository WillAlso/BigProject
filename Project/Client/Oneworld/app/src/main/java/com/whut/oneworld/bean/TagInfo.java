package com.whut.oneworld.bean;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tag_table")
public class TagInfo {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tag")
    private String tag;

    public TagInfo(@NonNull String tag) {
        this.tag = tag;
    }

    @NonNull
    public String getTag() {
        return tag;
    }

    public void setTag(@NonNull String tag) {
        this.tag = tag;
    }
}
