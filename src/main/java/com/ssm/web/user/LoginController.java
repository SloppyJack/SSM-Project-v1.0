package com.ssm.web.user;

import com.ssm.dto.CodeMsg;
import com.ssm.dto.Result;
import com.ssm.entity.LocalAuth;
import com.ssm.entity.PersonInfo;
import com.ssm.service.LocalAuthService;
import com.ssm.service.PersonInfoService;
import com.ssm.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
    @Autowired
    private PersonInfoService personInfoService;
    @Autowired
    private LocalAuthService localAuthService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    private Result login(HttpServletRequest request) {
        Map<String,Object> modelMap = new HashMap<>();
        //获取parentId
        String psw = HttpServletRequestUtil.getString(request,"psw");
        String loginName = HttpServletRequestUtil.getString(request,"loginName");
        LocalAuth localAuth = localAuthService.queryLocalAuthByUserName(loginName);
        if (localAuth != null && localAuth.getPersonInfo() != null && localAuth.getPersonInfo().getUserId() != null &&
                loginName.equals(localAuth.getUserName()) && psw.equals(localAuth.getPassword())){
            PersonInfo user = personInfoService.queryPersonInfoByUserId(localAuth.getPersonInfo().getUserId());
            request.getSession().setAttribute("user",user);
            modelMap.put("redirectUrl","shopAdmin/index");
            return Result.success(modelMap);
        }
        return Result.error(CodeMsg.USER_LOGIN_FAILED);
    }
}
