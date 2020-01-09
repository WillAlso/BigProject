package com.whut.oneworld.Artical;

import com.whut.oneworld.bean.ArticalInfo;
import com.whut.oneworld.util.RetrofitFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ArticalRepository {
    private ArticalViewModel articalViewModel;
    private Retrofit retrofit;
    private static volatile ArticalRepository articalRepository;

    private ArticalRepository(ArticalViewModel articalViewModel) {
      retrofit = RetrofitFactory.getInstance();
      this.articalViewModel = articalViewModel;
    }
    public static ArticalRepository getInstance(ArticalViewModel articalViewModel) {
        if (articalRepository==null) {
            synchronized (ArticalRepository.class) {
                if (articalRepository==null) {
                    articalRepository = new ArticalRepository(articalViewModel);
                }
            }
        }
        return articalRepository;
    }

    public void getAllArtical() {
        ArticalRequest articalRequest = retrofit.create(ArticalRequest.class);
        Call<List<ArticalInfo>> call = articalRequest.getAllArtical();
        call.enqueue(new Callback<List<ArticalInfo>>() {
            @Override
            public void onResponse(Call<List<ArticalInfo>> call, Response<List<ArticalInfo>> response) {
                articalViewModel.getArticalInfos().postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ArticalInfo>> call, Throwable t) {

            }
        });
    }
}
