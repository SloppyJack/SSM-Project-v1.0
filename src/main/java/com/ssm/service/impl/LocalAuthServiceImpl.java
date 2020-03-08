package com.ssm.service.impl;

import com.ssm.dao.LocalAuthDao;
import com.ssm.entity.LocalAuth;
import com.ssm.service.LocalAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.service.impl
 * @date: 2020/3/5 20:46
 **/
@Service
public class LocalAuthServiceImpl implements LocalAuthService {
    @Autowired
    private LocalAuthDao localAuthDao;
    @Override
    public LocalAuth queryLocalAuthByUserId(Long userId) {
        return localAuthDao.queryLocalAuthByUserId(userId);
    }

    @Override
    public LocalAuth queryLocalAuthByUserName(String userName) {
        return localAuthDao.queryLocalAuthByUserName(userName);
    }
}
