package com.whut.oneworld.huajian;

import com.whut.oneworld.bean.ArticalInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HuajianRequest {
    @GET("/gethotartical")
    Call<List<ArticalInfo>> getHotArtical();
}
