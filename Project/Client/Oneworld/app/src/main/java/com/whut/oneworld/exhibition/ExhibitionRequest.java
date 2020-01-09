package com.whut.oneworld.exhibition;

import com.whut.oneworld.bean.ExhibitionCommentInfo;
import com.whut.oneworld.bean.ExhibitionInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ExhibitionRequest {
    @GET("/getallexhibition")
    Call<List<ExhibitionInfo>> getAllExhibition();
    @POST("/getexhibitioncomment")
    @FormUrlEncoded
    Call<List<ExhibitionCommentInfo>> getExhibitionComment(@Field("exhibitionNum") int exhibitionNum);
}
