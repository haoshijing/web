package com.hubei.web.admin.service;

import com.hubei.base.mapper.impl.AdminMapper;
import com.hubei.base.po.AdminPo;
import com.hubei.base.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

@Repository
public class AdminService {

    @Value("${saltEncrypt}")
    private String saltEncrypt;
    @Autowired
    private AdminMapper adminMapper;


    public boolean checkUser(String userName,String password){
        Boolean checkRet  = false;
        AdminPo adminPo = adminMapper.selectByUsername(userName);
        if(adminPo != null){
            String dbPassword = adminPo.getPassword();
            String userPassword = MD5Util.md5(MD5Util.md5(password)+saltEncrypt);
            checkRet =  StringUtils.equals(dbPassword,userPassword);
        }
        return checkRet;
    }
}
