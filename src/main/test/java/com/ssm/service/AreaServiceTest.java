package com.ssm.service;

import com.ssm.BaseTest;
import com.ssm.dao.AreaDao;
import com.ssm.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.com.ssm.service
 * @date:2019/7/24
 **/
public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void testAreaService(){
        List<Area> areaList = areaService.getAreaList();
        for (Area temp:areaList){
            System.out.println(temp.getAreaName()+"--------------------------");
        }
        assertEquals(2,areaList.size());
    }
}
