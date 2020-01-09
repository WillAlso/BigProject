package com.whut.oneworldserver.service.serviceImpl;

import com.whut.oneworldserver.bean.ArticalInfo;
import com.whut.oneworldserver.dao.ArticalDao;
import com.whut.oneworldserver.service.ArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticalServiceImpl implements ArticalService {
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    ArticalDao articalDao;

    @Override
    public List<ArticalInfo> getAllArtical() {return articalDao.getAllArtical();}
}
