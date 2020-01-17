package com.ssm.service.impl;

import com.ssm.dao.HeadNewsDao;
import com.ssm.entity.HeadNews;
import com.ssm.service.HeadNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.service.impl
 * @date:2019/11/27
 **/
@Service
public class HeadNewsServiceImpl implements HeadNewsService {
    @Autowired
    private HeadNewsDao headNewsDao;

    @Override
    public List<HeadNews> getHeadNewsList(HeadNews headNewsCondition) throws IOException {
        return headNewsDao.queryHeadNews(headNewsCondition);
    }
}
