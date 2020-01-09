package com.whut.oneworld.login.conuserinfo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.whut.oneworld.bean.UserInfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {UserInfo.class}, version = 1, exportSchema = false)
public abstract class UserInfoDatabase extends RoomDatabase {
    public abstract UserInfoDao userInfoDao();

    private static volatile UserInfoDatabase INSTANCE;
//    private UserInfoDatabase(){}

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);

    public static UserInfoDatabase getUserDataBase(Context context) {
        if (INSTANCE == null) {
            synchronized (UserInfoDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UserInfoDatabase.class, "user_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
