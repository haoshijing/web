package com.hubei.web.portal.controller;

import com.hubei.web.portal.service.IndexService;
import com.hubei.web.portal.vo.ContentDataVo;
import com.hubei.web.portal.vo.MoreContentDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;


    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        ContentDataVo contentDataVo =  indexService.obtainIndexData(null);
        modelAndView.addObject("contentDataVo",contentDataVo);
        return  modelAndView;
   }
    @RequestMapping("/menu")
    public ModelAndView index(Integer menuId,ModelAndView modelAndView){
        modelAndView.setViewName("index");
        ContentDataVo contentDataVo =  indexService.obtainIndexData(menuId);
        modelAndView.addObject("contentDataVo",contentDataVo);
        return  modelAndView;
    }

    @RequestMapping("/more")
    public ModelAndView more(Integer menuId,ModelAndView modelAndView){
        modelAndView.setViewName("more");
        MoreContentDataVo contentDataVo =  indexService.more(menuId);
        modelAndView.addObject("contentDataVo",contentDataVo);
        return  modelAndView;
    }
}
