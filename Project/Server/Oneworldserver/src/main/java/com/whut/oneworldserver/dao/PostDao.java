package com.whut.oneworldserver.dao;

import com.whut.oneworldserver.bean.PostCommentInfo;
import com.whut.oneworldserver.bean.PostInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Dao数据库交互，应注意与mapper中的mapper文件保持一致，否者容易出错
 */

public interface PostDao {
    List<PostInfo> getAllPost();

    List<PostCommentInfo> getPostComment(int postNum);
    void insertComment(@Param("postCommentInfo") PostCommentInfo postCommentInfo);
}
