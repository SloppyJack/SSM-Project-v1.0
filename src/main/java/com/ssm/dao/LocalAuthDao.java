package com.ssm.dao;

import com.ssm.entity.LocalAuth;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.dao
 * @date: 2020/3/5 20:42
 **/
public interface LocalAuthDao {

    /**
     * 通过userId查询本地用户
     * @param userId
     * @return
     */
    LocalAuth queryLocalAuthByUserId(Long userId);

    /**
     * 通过userName查询本地用户
     * @param userName
     * @return
     */
    LocalAuth queryLocalAuthByUserName(String userName);
}
