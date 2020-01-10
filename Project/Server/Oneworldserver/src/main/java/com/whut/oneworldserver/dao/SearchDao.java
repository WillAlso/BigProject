package com.whut.oneworldserver.dao;

import com.whut.oneworldserver.bean.ArticalInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchDao {
    List<ArticalInfo> getSearchArtical(@Param("title") String title);
}
