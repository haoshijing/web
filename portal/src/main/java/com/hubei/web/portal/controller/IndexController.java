package com.hubei.web.portal.controller;

import com.google.common.collect.Lists;
import com.hubei.web.portal.service.IndexService;
import com.hubei.web.portal.vo.ContentDataVo;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        ContentDataVo contentDataVo =  indexService.obtainIndexData();
        return  modelAndView;
   }
}
