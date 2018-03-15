package com.hubei.web.admin.web;

import com.hubei.web.admin.inteceptor.AuthInterceptor;
import com.hubei.web.admin.inteceptor.ProcessInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.web
 * @email cn.lu.duke@gmail.com
 * @date January 14, 2018
 */
@Configuration
@Slf4j
public class WebMvcConf extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Autowired
    private ProcessInterceptor processInterceptor;

    /**
     * 请求拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册监控拦截器
        registry.addInterceptor(processInterceptor)
                .addPathPatterns("/content/**").
                addPathPatterns("/menu/**").
                addPathPatterns("/login")
                .addPathPatterns("/user/**").
                excludePathPatterns("/image/**");
//        registry.addInterceptor(authInterceptor)
//                .addPathPatterns("/**");
    }



}
