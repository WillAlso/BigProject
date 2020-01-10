package com.whut.oneworld.login.conuserinfo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.whut.oneworld.bean.UserInfo;

@Dao
public interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserInfo userInfo);

    @Query("SELECT * FROM user_table WHERE serialNum=:serialNum")
    LiveData<UserInfo> getLocalUser(int serialNum);

    @Query("SELECT * FROM user_table LIMIT 1")
    LiveData<UserInfo> getLocalUserOne();
}
