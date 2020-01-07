package com.whut.oneworldserver.service.serviceImpl;

import com.whut.oneworldserver.bean.ArticalInfo;
import com.whut.oneworldserver.dao.HuajianDao;
import com.whut.oneworldserver.service.HuajianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuajianServiceImpl implements HuajianService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    HuajianDao huajianDao;

    @Override
    public List<ArticalInfo> getHotArtical() {
        return huajianDao.getHotArtical();
    }
}
