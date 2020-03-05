package com.ssm.dao;

import com.ssm.entity.PersonInfo;
import org.springframework.stereotype.Repository;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.dao
 * @date: 2020/3/5 19:47
 **/
@Repository
public interface PersonInfoDao {

    /**
     * 根据登录名查询用户
     * @param loginName
     * @return
     */
    PersonInfo queryPersonInfoByLoginName(String loginName);
}
