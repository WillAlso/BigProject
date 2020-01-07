package com.whut.oneworld.post;

import com.whut.oneworld.bean.PostInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 请求网络接口
 */

public interface PostRequest {

    //Call<>中加上实体类，会自动使用Gson解析
    @GET("/getallpost")
    Call<List<PostInfo>> getAllPost();
}
