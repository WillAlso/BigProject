package com.whut.oneworld.search;

import com.whut.oneworld.bean.ArticalInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchRequest {

    @GET("/getsearchartical")
    Call<List<ArticalInfo>> getSearchArtical(@Query("title") String title);
}
