package com.ssm.service;

import com.ssm.entity.PersonInfo;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.service
 * @date: 2020/3/5 20:04
 **/
public interface PersonInfoService {

    PersonInfo queryPersonInfoByUserId(Long userId);
}
