package com.whut.oneworldserver.service.serviceImpl;

import com.whut.oneworldserver.bean.ExhibitionInfo;
import com.whut.oneworldserver.dao.ExhibitionDao;
import com.whut.oneworldserver.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitionServiceImpl implements ExhibitionService {
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    ExhibitionDao exhibitionDao;

    @Override
    public List<ExhibitionInfo> getAllExhibition() {
        return exhibitionDao.getAllExhibition();
    }
}
