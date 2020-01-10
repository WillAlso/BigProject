package com.whut.oneworld.login.conuserinfo;

import com.whut.oneworld.bean.SignInfo;
import com.whut.oneworld.bean.UserInfo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserInfoRequest {
    @POST("/getuserforlogin")
    @FormUrlEncoded
    Call<UserInfo>  getUserByPhone(@Field("param") String param, @Field("passWord") String passWord);

    @POST("/sendcode")
    @FormUrlEncoded
    Call<String> sendCode(@Field("email")String email);

    @POST("/signuser")
    @FormUrlEncoded
    Call<Integer> signUser(@Field("msg") String msg);
}
