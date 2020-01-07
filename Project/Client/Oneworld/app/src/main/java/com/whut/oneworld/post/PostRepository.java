package com.whut.oneworld.post;

import android.util.Log;

import com.whut.oneworld.bean.PostInfo;
import com.whut.oneworld.util.RetrofitFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * 仓库类，是MVVM框架的Model，与数据进行交互，获取数据
 * 这里请求网络
 */


public class PostRepository {

    private PostViewModel postViewModel;
    private Retrofit retrofit;
    private static volatile PostRepository postRepository;

    private PostRepository(PostViewModel postViewModel) {
        retrofit = RetrofitFactory.getInstance();
        this.postViewModel = postViewModel;
    }

    public static PostRepository getInstance(PostViewModel postViewModel) {
        if (postRepository == null) {
            synchronized (PostRepository.class) {
                if (postRepository == null) {
                    postRepository = new PostRepository(postViewModel);
                }
            }
        }
        return postRepository;
    }

    public void getAllPost() {
        PostRequest postRequest = retrofit.create(PostRequest.class);
        Call<List<PostInfo>> call = postRequest.getAllPost();
        call.enqueue(new Callback<List<PostInfo>>() {
            @Override
            public void onResponse(Call<List<PostInfo>> call, Response<List<PostInfo>> response) {
                postViewModel.getPostInfos().postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostInfo>> call, Throwable t) {
                Log.d("ONE WORLD DEBUG", "请求超时");
            }
        });
    }
}
