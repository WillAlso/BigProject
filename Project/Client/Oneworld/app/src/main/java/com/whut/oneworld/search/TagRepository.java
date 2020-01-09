package com.whut.oneworld.search;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.whut.oneworld.bean.ArticalInfo;
import com.whut.oneworld.bean.TagInfo;
import com.whut.oneworld.util.RetrofitFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TagRepository {
    private TagDao tagDao;
    private LiveData<List<TagInfo>> tagInfos;
    private TagDatabase db;
    private Retrofit retrofit;
    private TagViewModel tagViewModel;

    public TagRepository(Application application, TagViewModel tagViewModel) {
        db = TagDatabase.getDatabase(application);
        tagDao = db.tagDao();
        tagInfos = tagDao.getAllTagInfo();
        retrofit = RetrofitFactory.getInstance();
        this.tagViewModel = tagViewModel;
    }

    LiveData<List<TagInfo>> getAllTagInfo() {
        return tagInfos;
    }


    public void insert(TagInfo tagInfo) {
        TagDatabase.databaseWriteExecutor.execute(() -> {
            tagDao.insert(tagInfo);
        });
    }

    public void deleteAll() {
        TagDatabase.databaseWriteExecutor.execute(() -> {
            tagDao.deleteAll();
        });
    }

    public void deleteTag(TagInfo tagInfo) {
        TagDatabase.databaseWriteExecutor.execute(()->{
            tagDao.deleteTag(tagInfo);
        });
    }

    public void getSearchArtical(String title) {
        SearchRequest request = retrofit.create(SearchRequest.class);
        Call<List<ArticalInfo>> call = request.getSearchArtical(title);
        TagDatabase.databaseWriteExecutor.execute(() -> {
            call.enqueue(new Callback<List<ArticalInfo>>() {
                @Override
                public void onResponse(Call<List<ArticalInfo>> call, Response<List<ArticalInfo>> response) {
                    tagViewModel.getArticalInfos().setValue(response.body());
                }

                @Override
                public void onFailure(Call<List<ArticalInfo>> call, Throwable t) {
                    tagViewModel.showError();
                }
            });
        });
    }
}
