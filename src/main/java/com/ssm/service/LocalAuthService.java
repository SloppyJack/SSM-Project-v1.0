package com.ssm.service;

import com.ssm.entity.LocalAuth;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.service
 * @date: 2020/3/5 20:45
 **/
public interface LocalAuthService {
    /**
     * 通过userId查询本地用户
     * @param userId
     * @return
     */
    LocalAuth queryLocalAuthByUserId(Long userId);
}
