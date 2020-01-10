package com.whut.oneworld.login.conuserinfo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.whut.oneworld.bean.SignInfo;
import com.whut.oneworld.bean.UserInfo;

public class UserInfoViewModel extends AndroidViewModel {

    private MutableLiveData<UserInfo> userInfo = new MutableLiveData<>();
    private UserInfoRepository repository;

    public UserInfoViewModel(@NonNull Application application) {
        super(application);
        repository = new UserInfoRepository(application, this);
    }

    public void insertLocal(UserInfo userInfo) {
        repository.insert(userInfo);
    }

    public MutableLiveData<UserInfo> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(MutableLiveData<UserInfo> userInfo) {
        this.userInfo = userInfo;
    }

    public void getNetUserInfoByPhone(String phoneNum, String password) {
        repository.getNetUserInfoByPhone(phoneNum, password);
    }

    public LiveData<UserInfo> findOneUser() {
        return repository.findOneUser();
    }

    public void sendCode(String email) {
        repository.sendCode(email);
    }

    public void signUser(String signInfo) {
        repository.signUser(signInfo);
    }

}
