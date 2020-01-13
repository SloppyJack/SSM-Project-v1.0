package com.ssm.dao;

import com.ssm.BaseTest;
import com.ssm.entity.HeadNews;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.dao
 * @date:2019/11/27
 **/
public class HeadNewsDaoTest extends BaseTest {
    @Autowired
    private HeadNewsDao headNewsDao;

    @Test
    public void testQueryHeadNews(){
        List<HeadNews> list = headNewsDao.queryHeadNews(new HeadNews());
        assertEquals(0,list.size());
    }
}
