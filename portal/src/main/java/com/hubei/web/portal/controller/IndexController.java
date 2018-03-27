package com.hubei.web.portal.controller;

import com.hubei.web.portal.service.IndexService;
import com.hubei.web.portal.vo.ContentDataVo;
import com.hubei.web.portal.vo.ContentDetailVo;
import com.hubei.web.portal.vo.MoreContentDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

   @RequestMapping("/detail/{id}")
   public ModelAndView contentDetail(@PathVariable Integer id,ModelAndView modelAndView){
       modelAndView.setViewName("detail");
       ContentDetailVo contentDetailVo =  indexService.contentDetail(id);
       modelAndView.addObject("contentDetailVo",contentDetailVo);
       return  modelAndView;
   }
    @RequestMapping("/func/{id}")
    public ModelAndView func(@PathVariable Integer id,ModelAndView modelAndView){
        modelAndView.setViewName("func");
        ContentDetailVo contentDetailVo =  indexService.contentDetail(id);
        modelAndView.addObject("contentDetailVo",contentDetailVo);
        return  modelAndView;
    }
    @RequestMapping("/menu")
    public ModelAndView index(Integer menuId,ModelAndView modelAndView){
        modelAndView.setViewName("index");
        ContentDataVo contentDataVo =  indexService.obtainIndexData(menuId);
        modelAndView.addObject("contentDataVo",contentDataVo);
        return  modelAndView;
    }

}
