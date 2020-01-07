package com.whut.oneworldserver.service;

import com.whut.oneworldserver.bean.PostInfo;

import java.util.List;

/**
 * Service接口，用于提供给@Autowired，自动组装
 */


public interface PostService {
    List<PostInfo> getAllPost();
}
