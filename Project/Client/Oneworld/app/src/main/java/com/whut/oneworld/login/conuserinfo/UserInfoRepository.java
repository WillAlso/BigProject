package com.whut.oneworld.login.conuserinfo;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.whut.oneworld.bean.SignInfo;
import com.whut.oneworld.bean.UserInfo;
import com.whut.oneworld.util.RetrofitFactory;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserInfoRepository {

    private UserInfoDao userInfoDao;
    private UserInfoDatabase db;
    private Retrofit retrofit;
    private UserInfoViewModel userInfoViewModel;

    public UserInfoRepository(Application application, UserInfoViewModel userInfoViewModel) {
        this.userInfoViewModel = userInfoViewModel;
        db = UserInfoDatabase.getUserDataBase(application);
        this.userInfoDao = db.userInfoDao();
        retrofit = RetrofitFactory.getInstance();
    }

    public LiveData<UserInfo> getLocalInfo(int serialNum){
        return userInfoDao.getLocalUser(serialNum);
    }

    public void insert(UserInfo userInfo){
        UserInfoDatabase.databaseWriteExecutor.execute(() -> {
            userInfoDao.insert(userInfo);
        });
    }

    public LiveData<UserInfo> findOneUser() {
        return userInfoDao.getLocalUserOne();
    }

    public void getNetUserInfoByPhone(String phoneNum, String password) {
        UserInfoRequest request = retrofit.create(UserInfoRequest.class);
        Call<UserInfo> call = request.getUserByPhone(phoneNum, password);
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                userInfoViewModel.getUserInfo().setValue(response.body());
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {

            }
        });
    }

    public void sendCode(String email) {
        UserInfoRequest request = retrofit.create(UserInfoRequest.class);
        Call<String> call = request.sendCode(email);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                EventBus.getDefault().post("-1");
            }
        });
    }

    public void signUser(String signInfo) {
        UserInfoRequest request = retrofit.create(UserInfoRequest.class);
        Call<Integer> call = request.signUser(signInfo);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                EventBus.getDefault().post(new Integer(-1));
            }
        });
    }

}
