package com.whut.oneworldserver.dao;

import com.whut.oneworldserver.bean.ExhibitionCommentInfo;
import com.whut.oneworldserver.bean.ExhibitionInfo;

import java.util.List;

public interface ExhibitionDao {
    List<ExhibitionInfo> getAllExhibition();

    List<ExhibitionCommentInfo> getExhibitionComment(int exhibitionNum);
}
