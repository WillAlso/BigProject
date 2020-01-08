package com.whut.oneworld.post.postdetail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.whut.oneworld.bean.PostCommentInfo;
import com.whut.oneworld.bean.PostInfo;

import java.util.ArrayList;
import java.util.List;

public class PostCommentViewModel extends ViewModel {

    private PostCommentRepository postCommentRepository = PostCommentRepository.getInstance(this);

    private MutableLiveData<List<PostCommentInfo>> postCommentInfos = new MutableLiveData<>();
    private MutableLiveData<PostInfo> postInfo = new MutableLiveData<>();

    public MutableLiveData<List<PostCommentInfo>> getPostCommentInfos() {
        return postCommentInfos;
    }

    public void setPostCommentInfos(MutableLiveData<List<PostCommentInfo>> postCommentInfos) {
        this.postCommentInfos = postCommentInfos;
    }

    public MutableLiveData<PostInfo> getPostInfo() {
        return postInfo;
    }

    public void setPostInfo(MutableLiveData<PostInfo> postInfo) {
        this.postInfo = postInfo;
    }

    public void getPostComment() {
        postCommentRepository.getPostComment(postInfo.getValue().getPostNum());
    }

    public PostCommentRepository getPostCommentRepository() {
        return postCommentRepository;
    }

    public void setPostCommentRepository(PostCommentRepository postCommentRepository) {
        this.postCommentRepository = postCommentRepository;
    }
}
