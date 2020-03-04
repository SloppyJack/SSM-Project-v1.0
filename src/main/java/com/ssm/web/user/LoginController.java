package com.ssm.web.user;

import com.ssm.dto.Result;
import com.ssm.util.HttpServletRequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.web.Others
 * @date: 2020/3/4 21:49
 **/
@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    private Result login(HttpServletRequest request) {
        Map<String,Object> modelMap = new HashMap<>();
        //获取parentId
        String psw = HttpServletRequestUtil.getString(request,"psw");
        String loginName = HttpServletRequestUtil.getString(request,"loginName");
        //todo 完善登录代码
        return null;

    }
}
