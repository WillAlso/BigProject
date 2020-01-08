package com.whut.oneworld.exhibition;

import android.util.Log;

import com.whut.oneworld.bean.ExhibitionInfo;
import com.whut.oneworld.util.RetrofitFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ExhibitionRepository {
    private ExhibitionViewModel exhibitionViewModel;
    private Retrofit retrofit;
    private static volatile ExhibitionRepository exhibitionRepository;

    private ExhibitionRepository(ExhibitionViewModel exhibitionViewModel) {
        retrofit = RetrofitFactory.getInstance();
        this.exhibitionViewModel = exhibitionViewModel;
    }

    public static ExhibitionRepository getInstance(ExhibitionViewModel exhibitionViewModel) {
        if (exhibitionRepository == null) {
            synchronized (ExhibitionRepository.class) {
                if (exhibitionRepository == null) {
                    exhibitionRepository = new ExhibitionRepository(exhibitionViewModel);
                }
            }
        }
        return exhibitionRepository;
    }
    public void getAllPost() {
        ExhibitionRequest exhibitionRequest = retrofit.create(ExhibitionRequest.class);
        Call<List<ExhibitionInfo>> call = exhibitionRequest.getAllExhibition();
        call.enqueue(new Callback<List<ExhibitionInfo>>() {
            @Override
            public void onResponse(Call<List<ExhibitionInfo>> call, Response<List<ExhibitionInfo>> response) {
                exhibitionViewModel.getExhibitionInfos().postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ExhibitionInfo>> call, Throwable t) {
                Log.d("ONE WORLD DEBUG","请求超时");

            }
        });
    }
}
