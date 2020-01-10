package com.whut.oneworld.exhibition.exhibitiondetail;

import com.whut.oneworld.bean.ExhibitionCommentInfo;
import com.whut.oneworld.exhibition.ExhibitionRepository;
import com.whut.oneworld.exhibition.ExhibitionRequest;
import com.whut.oneworld.exhibition.ExhibitionViewModel;
import com.whut.oneworld.util.RetrofitFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ExhibitionCommentRepository {
    private ExhibitionCommentViewModel exhibitionCommentViewModel;
    private Retrofit retrofit;
    private static volatile ExhibitionCommentRepository exhibitionCommentRepository;

    private ExhibitionCommentRepository(ExhibitionCommentViewModel exhibitionCommentViewModel) {
        this.retrofit = RetrofitFactory.getInstance();
        this.exhibitionCommentViewModel = exhibitionCommentViewModel;
    }

    public static ExhibitionCommentRepository getInstance(ExhibitionCommentViewModel exhibitionCommentViewModel) {
        if(exhibitionCommentRepository == null) {
            synchronized (ExhibitionCommentRepository.class) {
                if (exhibitionCommentRepository == null) {
                    exhibitionCommentRepository = new ExhibitionCommentRepository(exhibitionCommentViewModel);
                }
            }
        }
        return exhibitionCommentRepository;
    }

    public void getExhibitionComment(int exhibitionNum) {
        ExhibitionRequest exhibitionRequest = retrofit.create(ExhibitionRequest.class);
        Call<List<ExhibitionCommentInfo>> call = exhibitionRequest.getExhibitionComment(exhibitionNum);
        call.enqueue(new Callback<List<ExhibitionCommentInfo>>() {
            @Override
            public void onResponse(Call<List<ExhibitionCommentInfo>> call, Response<List<ExhibitionCommentInfo>> response) {
                List<ExhibitionCommentInfo> commentInfos = response.body();
                exhibitionCommentViewModel.getExhibitionCommentInfos().setValue(commentInfos);
            }

            @Override
            public void onFailure(Call<List<ExhibitionCommentInfo>> call, Throwable t) {

            }
        });
    }
}
