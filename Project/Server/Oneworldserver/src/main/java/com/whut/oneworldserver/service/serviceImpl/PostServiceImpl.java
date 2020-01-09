package com.whut.oneworldserver.service.serviceImpl;

import com.whut.oneworldserver.bean.PostCommentInfo;
import com.whut.oneworldserver.bean.PostInfo;
import com.whut.oneworldserver.dao.PostDao;
import com.whut.oneworldserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现类，被Controller调用返回给Controller结果
 * 调用Dao，与数据库交互
 */

@Service
public class PostServiceImpl implements PostService {

    // 加上下面警告，否则报错
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    PostDao postDao;

    @Override
    public List<PostInfo> getAllPost() {
        return postDao.getAllPost();
    }

    @Override
    public List<PostCommentInfo> getPostComment(int postNum) {
        return postDao.getPostComment(postNum);
    }

    @Override
    public void insertComment(PostCommentInfo postCommentInfo) {
        postDao.insertComment(postCommentInfo);
    }
}
