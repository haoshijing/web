package com.hubei.web.portal.controller;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

   @Builder
   @Data
    public  static  class DataItem{
        private Integer id;
    }
    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        List<DataItem> datas = Lists.newArrayList();
        datas.add(DataItem.builder().id(1).build());
        datas.add(DataItem.builder().id(2).build());
        modelAndView.addObject("test","232432");
        modelAndView.addObject("datas",datas);
        modelAndView.setViewName("list");
        return  modelAndView;
   }
}
