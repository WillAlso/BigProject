package com.whut.oneworld.post;

import com.whut.oneworld.bean.PostCommentInfo;
import com.whut.oneworld.bean.PostInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 请求网络接口
 */

public interface  PostRequest {

    //Call<>中加上实体类，会自动使用Gson解析
    @GET("/getallpost")
    Call<List<PostInfo>> getAllPost();

    @POST("/getpostcomment")
    @FormUrlEncoded
    Call<List<PostCommentInfo>> getPostComment(@Field("postNum") int postNum);
}
