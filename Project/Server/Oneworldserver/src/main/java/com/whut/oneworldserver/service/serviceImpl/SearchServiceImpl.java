package com.whut.oneworldserver.service.serviceImpl;

import com.whut.oneworldserver.bean.ArticalInfo;
import com.whut.oneworldserver.dao.SearchDao;
import com.whut.oneworldserver.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    SearchDao searchDao;

    public List<ArticalInfo> getSearchArtical(String title) {
        return searchDao.getSearchArtical(title);
    }
}
