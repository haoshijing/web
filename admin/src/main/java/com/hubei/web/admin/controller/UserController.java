package com.hubei.web.admin.controller;

import com.google.common.collect.Lists;
import com.hubei.base.ApiResponse;
import com.hubei.web.admin.controller.response.UserDataResponse;
import com.hubei.web.admin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController{

    @Autowired
    private AdminService adminService;

    @RequestMapping("/info")
    public ApiResponse<UserDataResponse> getUserInfo(){
        UserDataResponse response = new UserDataResponse();
        response.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        response.setRoles(Lists.newArrayList("admin"));
        response.setIntroduction("");
        response.setName("admin");
        return new ApiResponse<>(response);
    }
}
