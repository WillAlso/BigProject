package com.whut.oneworld.post;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.whut.oneworld.bean.PostInfo;

import java.util.List;

/**
 * MVVM中的VM，含有View的数据MutableLiveData<List<PostInfo>> postInfos
 */

public class PostViewModel extends ViewModel {

    // MutableLiveData<>可变的Livedata
    // List<PostInfo>原始数据
    private MutableLiveData<List<PostInfo>> postInfos = new MutableLiveData<>();
    // 仓库类，使用仓库类提供的网络请求方法，获取数据
    private PostRepository postRepository = PostRepository.getInstance(this);

    public MutableLiveData<List<PostInfo>> getPostInfos() {
        return postInfos;
    }

    public void setPostInfos(MutableLiveData<List<PostInfo>> postInfos) {
        this.postInfos = postInfos;
    }

    // 提供给view层使用，其中调用postRepository的方法，postRepository的方法内获取网络数据
    public void getAllPost() {
        postRepository.getAllPost();
    }
}
