package com.hubei.web.admin.service;

import com.hubei.base.enums.Status;
import com.hubei.base.mapper.impl.ContentMapper;
import com.hubei.base.po.ContentPo;
import com.hubei.web.admin.controller.request.ContentInsertRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContentService {
    @Autowired
    ContentMapper contentMapper;
    public Integer insert(ContentInsertRequest request) {
        Integer ret = 0;
        ContentPo contentPo = new ContentPo();
        contentPo.setInsertTime(System.currentTimeMillis());
        contentPo.setLastUpdateTime(System.currentTimeMillis());
        contentPo.setMenuId(request.getMenuId());
        contentPo.setName(request.getName());
        contentPo.setUrl(request.getUrl());
        contentPo.setSort(request.getSort());
        contentPo.setImage(request.getImage());
        contentPo.setStatus(Status.OK.getCode());
        ret = contentMapper.insert(contentPo);
        return ret;
    }
}
