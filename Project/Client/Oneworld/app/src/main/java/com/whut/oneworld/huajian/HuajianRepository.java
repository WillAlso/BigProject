package com.whut.oneworld.huajian;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.whut.oneworld.MainActivity;
import com.whut.oneworld.bean.ArticalInfo;
import com.whut.oneworld.util.RetrofitFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HuajianRepository {


    public static HuajianRepository repository;
    private Retrofit retrofit;
    private HuajianViewModel huajianViewModel;

    private HuajianRepository(HuajianViewModel huajianViewModel) {
        retrofit = RetrofitFactory.getInstance();
        this.huajianViewModel = huajianViewModel;
    }

    public static HuajianRepository getInstance(HuajianViewModel huajianViewModel) {
        if (repository == null) {
            synchronized (HuajianRepository.class) {
                if (repository == null) {
                    repository = new HuajianRepository(huajianViewModel);
                }
            }
        }
        return repository;
    }

    public void getHotArtical() {

        HuajianRequest huajianRequest = retrofit.create(HuajianRequest.class);
        Call<List<ArticalInfo>> call = huajianRequest.getHotArtical();
        call.enqueue(new Callback<List<ArticalInfo>>() {
            @Override
            public void onResponse(Call<List<ArticalInfo>> call, Response<List<ArticalInfo>> response) {
                huajianViewModel.getArticalInfos().postValue(response.body());
                Log.d("ONE WORLD DEBUG", huajianViewModel.getArticalInfos().toString());
            }
            @Override
            public void onFailure(Call<List<ArticalInfo>> call, Throwable t) {
                Log.d("ONE WORLD DEBUG", "请求超时");
            }
        });
    }
}
