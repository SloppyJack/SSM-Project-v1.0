package com.ssm.web.superadmin;

import com.ssm.entity.Area;
import com.ssm.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.web.superadmin
 * @date:2019/7/24
 **/
@Controller
@RequestMapping("/superAdmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listArea",method = RequestMethod.GET)
    //ResponseBody会自动转换为Json
    @ResponseBody
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Area> list = new ArrayList<>();
        list=areaService.getAreaList();
        for (Area area:list){
            modelMap.put("areaName",area.getAreaName());
        }
        return modelMap;
    }
}
