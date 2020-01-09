package com.whut.oneworld.post.postdetail;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.whut.oneworld.bean.PostCommentInfo;
import com.whut.oneworld.post.PostRepository;
import com.whut.oneworld.post.PostRequest;
import com.whut.oneworld.post.PostViewModel;
import com.whut.oneworld.util.RetrofitFactory;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostCommentRepository {

    private PostCommentViewModel postCommentViewModel;
    private Retrofit retrofit;
    private static volatile PostCommentRepository postCommentRepository;

    private PostCommentRepository(PostCommentViewModel postCommentViewModel) {
        this.retrofit = RetrofitFactory.getInstance();
        this.postCommentViewModel = postCommentViewModel;
    }

    public static PostCommentRepository getInstance(PostCommentViewModel postCommentViewModel) {
        if (postCommentRepository == null) {
            synchronized (PostCommentRepository.class) {
                if (postCommentRepository == null) {
                    postCommentRepository = new PostCommentRepository(postCommentViewModel);
                }
            }
        }
        return postCommentRepository;
    }

    public void getPostComment(int postNum) {
        PostRequest postRequest = retrofit.create(PostRequest.class);
        Call<List<PostCommentInfo>> call = postRequest.getPostComment(postNum);
        call.enqueue(new Callback<List<PostCommentInfo>>() {
            @Override
            public void onResponse(Call<List<PostCommentInfo>> call, Response<List<PostCommentInfo>> response) {
                // setValue 和 postValue有区别，但非特殊情况效果基本相同
                List<PostCommentInfo> commentInfos = response.body();
                postCommentViewModel.getPostCommentInfos().setValue(commentInfos);
            }
            @Override
            public void onFailure(Call<List<PostCommentInfo>> call, Throwable t) {
            }
        });
    }

    public void insertComment(PostCommentInfo postCommentInfo) {
        PostRequest request = retrofit.create(PostRequest.class);

        Call<String> call = request.insertComment((new Gson()).toJson(postCommentInfo));
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                List<PostCommentInfo> list = postCommentViewModel.getPostCommentInfos().getValue();
                list.add(postCommentInfo);
                postCommentViewModel.getPostCommentInfos().setValue(list);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
