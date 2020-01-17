package com.ssm.service.impl;

import com.ssm.dao.AreaDao;
import com.ssm.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssm.service.AreaService;

import java.util.List;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.service.impl
 * @date:2019/7/24
 **/
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
