package com.hubei.web.admin.controller;

import com.hubei.base.ApiResponse;
import com.hubei.base.mapper.impl.ContentMapper;
import com.hubei.base.po.ContentPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentMapper contentMapper;
    @RequestMapping("/selectList")
    public ApiResponse<List<ContentPo>> queryList(String name, Integer page){
        if(page == 0){
            page = 1;
        }
        Integer offset = (page-1)*50;
        ContentPo queryPo = new ContentPo();
        queryPo.setOffset(offset);
        queryPo.setName(name);
        List<ContentPo> contentPos = contentMapper.selectList(queryPo);
        return new ApiResponse<>(contentPos);
    }
}
