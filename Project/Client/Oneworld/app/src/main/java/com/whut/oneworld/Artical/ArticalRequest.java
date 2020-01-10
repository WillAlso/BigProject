package com.whut.oneworld.Artical;

import com.whut.oneworld.bean.ArticalInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArticalRequest {
    @GET("/getallartical")
    Call<List<ArticalInfo>> getAllArtical();
}
