package com.ssm.service;

import com.ssm.BaseTest;
import com.ssm.entity.LocalAuth;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.service
 * @date: 2020/3/5 20:47
 **/
public class LocalAuthServiceTest extends BaseTest {
    @Autowired
    private LocalAuthService localAuthService;

    @Test
    public void testQueryByUserId(){
        LocalAuth localAuth = localAuthService.queryLocalAuthByUserId(1L);
        assertEquals("jack",localAuth.getUserName());
    }
}
