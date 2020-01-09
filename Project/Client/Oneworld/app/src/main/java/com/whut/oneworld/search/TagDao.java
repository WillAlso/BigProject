package com.whut.oneworld.search;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.whut.oneworld.bean.TagInfo;

import java.util.List;

@Dao
public interface TagDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TagInfo tagInfo);

    @Query("DELETE FROM tag_table")
    void deleteAll();

    @Query("SELECT tag FROM tag_table")
    LiveData<List<TagInfo>> getAllTagInfo();

    @Delete
    void deleteTag(TagInfo tagInfo);

}
