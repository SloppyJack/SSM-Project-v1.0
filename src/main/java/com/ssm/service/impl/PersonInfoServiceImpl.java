package com.ssm.service.impl;

import com.ssm.dao.PersonInfoDao;
import com.ssm.entity.PersonInfo;
import com.ssm.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.service.impl
 * @date: 2020/3/5 20:04
 **/
@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    private PersonInfoDao personInfoDao;
    @Override
    public PersonInfo queryPersonInfoByLoginName(String loginName) {
        return personInfoDao.queryPersonInfoByLoginName(loginName);
    }
}
