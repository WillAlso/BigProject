package com.example.roomviewex01.bean;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
//    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "word")
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public void setWord(@NonNull String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
