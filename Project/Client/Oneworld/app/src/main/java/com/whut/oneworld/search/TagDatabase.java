package com.whut.oneworld.search;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.whut.oneworld.bean.TagInfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {TagInfo.class}, version = 1, exportSchema = false)
public abstract class TagDatabase extends RoomDatabase {

    public abstract TagDao tagDao();

    private static volatile TagDatabase INSTANCE;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(2);

    static TagDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TagDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TagDatabase.class, "tag_database").build();
                }
            }
        }
        return INSTANCE;
    }

}
