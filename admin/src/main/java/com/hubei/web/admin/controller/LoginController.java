package com.hubei.web.admin.controller;

import com.hubei.base.ApiResponse;
import com.hubei.base.constants.RetCode;
import com.hubei.web.admin.auth.AdminAuthCacheService;
import com.hubei.web.admin.auth.AdminAuthInfo;
import com.hubei.web.admin.controller.request.LoginDataRequest;
import com.hubei.web.admin.controller.response.LoginResponse;
import com.hubei.web.admin.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminAuthCacheService adminAuthCacheService;

    @RequestMapping("/login")
    @ResponseBody
    public ApiResponse<LoginResponse> login(@RequestBody LoginDataRequest loginDataRequest){
        LoginResponse loginResponse = new LoginResponse();

        if(StringUtils.isEmpty(loginDataRequest.getName()) ||
                StringUtils.isEmpty(loginDataRequest.getPassword())){
            return new ApiResponse<>(RetCode.PARAM_EROR,"参数错误",loginResponse);
        }
        AdminAuthInfo adminAuthInfo = new AdminAuthInfo();

       boolean check =   adminService.checkUser(loginDataRequest.getName(),loginDataRequest.getPassword());
        if(check){
            String token = UUID.randomUUID().toString().replace("-","");
            loginResponse.setToken(token);
            loginResponse.setSucc(true);
            adminAuthInfo.setToken(token);
            adminAuthInfo.setUserName(loginDataRequest.getName());
            adminAuthCacheService.setTokenCache(token,adminAuthInfo);
        }
        return new ApiResponse<>(loginResponse);
    }
}
