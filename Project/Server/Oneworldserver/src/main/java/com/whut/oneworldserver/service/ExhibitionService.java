package com.whut.oneworldserver.service;

import com.whut.oneworldserver.bean.ExhibitionCommentInfo;
import com.whut.oneworldserver.bean.ExhibitionInfo;

import java.util.List;

public interface ExhibitionService {
    List<ExhibitionInfo> getAllExhibition();

    List<ExhibitionCommentInfo> getExhibitionComment(int exhibitionNum);
}
