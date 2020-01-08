package com.whut.oneworld.exhibition;

import com.whut.oneworld.bean.ExhibitionInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ExhibitionRequest {
    @GET("/getallexhibition")
    Call<List<ExhibitionInfo>> getAllExhibition();
}
