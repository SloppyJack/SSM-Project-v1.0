package com.ssm.service;

import com.ssm.BaseTest;
import com.ssm.entity.PersonInfo;
import com.ssm.service.PersonInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: java.com.ssm.service
 * @date: 2020/3/5 20:07
 **/
public class PersonInfoServiceTest extends BaseTest {
    @Autowired
    private PersonInfoService personInfoService;

    @Test
    public void testQueryByLoginName(){
        /*PersonInfo personInfo = personInfoService.queryPersonInfoByLoginName("jack");
        Long userId = 1L;
        assertEquals(userId,personInfo.getUserId());*/
    }
}
