package com.hubei.web.admin.controller;

import com.hubei.base.ApiResponse;
import com.hubei.base.mapper.impl.ContentMapper;
import com.hubei.base.mapper.impl.MenuMapper;
import com.hubei.base.po.ContentPo;
import com.hubei.base.po.MenuPo;
import com.hubei.web.admin.controller.request.ContentInsertRequest;
import com.hubei.web.admin.controller.response.ContentVo;
import com.hubei.web.admin.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Value("${imageHost}")
    private String imageHost;
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private ContentService contentService;
    @RequestMapping("/selectList")
    public ApiResponse<List<ContentVo>> queryList(String name, Integer page){
        if(page == 0){
            page = 1;
        }
        Integer offset = (page-1)*50;
        ContentPo queryPo = new ContentPo();
        queryPo.setOffset(offset);
        queryPo.setName(name);
        List<ContentPo> contentPos = contentMapper.selectList(queryPo);
        List<ContentVo> contentVos = contentPos.stream().map(contentPo -> {
            ContentVo contentVo = new ContentVo();
            StringBuilder sb = new StringBuilder();
            sb.append(imageHost).append("/admin/").append(contentPo.getImage());
            contentVo.setImage(sb.toString());
            MenuPo menuPo =menuMapper.selectById(contentPo.getMenuId());
            if(menuPo != null){
                contentVo.setMenuName(menuPo.getMenuName());
            }
            contentVo.setUrl(contentPo.getUrl());
            contentVo.setName(contentPo.getName());
            contentVo.setId(contentPo.getId());
            contentVo.setSort(contentPo.getSort());
            return  contentVo;
        }).collect(Collectors.toList());
        return new ApiResponse<>(contentVos);
    }

    @RequestMapping("/selectCount")
    public ApiResponse<Integer> selectCount(String name, Integer page){
        ContentPo queryPo = new ContentPo();
        queryPo.setName(name);
        Integer count = contentMapper.selectCount(queryPo);
        return new ApiResponse<>(count);
    }

    @RequestMapping("/insertContent")
    public ApiResponse<Integer> insertContent(@RequestBody ContentInsertRequest request){
        Integer count = contentService.insert(request);
        ContentPo contentPo = new ContentPo();

        return new ApiResponse<>(count);
    }

}
