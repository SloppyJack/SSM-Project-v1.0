package com.ssm.service;

import com.ssm.entity.HeadNews;

import java.io.IOException;
import java.util.List;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.service
 * @date:2019/11/27
 **/
public interface HeadNewsService {

    /**
     * 根据查询条件返回头条列表
     * @param headNewsCondition
     * @return
     * @throws IOException
     */
    List<HeadNews> getHeadNewsList(HeadNews headNewsCondition) throws IOException;
}
