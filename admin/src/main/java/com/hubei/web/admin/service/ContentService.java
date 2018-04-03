package com.hubei.web.admin.service;

import com.hubei.base.enums.Status;
import com.hubei.base.mapper.impl.ContentMapper;
import com.hubei.base.po.ContentPo;
import com.hubei.web.admin.controller.request.ContentInsertRequest;
import org.apache.commons.lang3.StringUtils;
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
        contentPo.setAdminUrl(request.getAdminUrl());
        contentPo.setSort(request.getSort());
        contentPo.setImage(request.getImage());
        contentPo.setDetailImage5(request.getDetailImage5());
        contentPo.setDetailImage4(request.getDetailImage4());
        contentPo.setDetailImage3(request.getDetailImage3());
        contentPo.setDetailImage2(request.getDetailImage2());
        contentPo.setDetailImage1(request.getDetailImage1());
        contentPo.setFuncImage5(request.getFuncImage5());
        contentPo.setFuncImage4(request.getFuncImage4());
        contentPo.setFuncImage3(request.getFuncImage3());
        contentPo.setFuncImage2(request.getFuncImage2());
        contentPo.setFuncImage1(request.getFuncImage1());
        contentPo.setStatus(Status.OK.getCode());
        ret = contentMapper.insert(contentPo);
        return ret;
    }

    public Integer update(ContentInsertRequest request) {
        ContentPo updatePo = new ContentPo();
        if(StringUtils.isNotEmpty(request.getImage())){
            updatePo.setImage(request.getImage());
        }
        if(StringUtils.isNotEmpty(request.getDetailImage1())){
            updatePo.setDetailImage1(request.getDetailImage1());
        }
        if(StringUtils.isNotEmpty(request.getDetailImage2())){
            updatePo.setDetailImage2(request.getDetailImage2());
        }
        if(StringUtils.isNotEmpty(request.getDetailImage3())){
            updatePo.setDetailImage3(request.getDetailImage3());
        }
        if(StringUtils.isNotEmpty(request.getDetailImage4())){
            updatePo.setDetailImage4(request.getDetailImage3());
        }
        if(StringUtils.isNotEmpty(request.getDetailImage5())){
            updatePo.setDetailImage5(request.getDetailImage5());
        }
        if(StringUtils.isNotEmpty(request.getFuncImage1())){
            updatePo.setFuncImage1(request.getFuncImage1());
        }
        if(StringUtils.isNotEmpty(request.getFuncImage2())){
            updatePo.setFuncImage2(request.getFuncImage2());
        }
        if(StringUtils.isNotEmpty(request.getFuncImage3())){
            updatePo.setFuncImage3(request.getFuncImage3());
        }
        if(StringUtils.isNotEmpty(request.getFuncImage4())){
            updatePo.setFuncImage4(request.getFuncImage4());
        }
        if(StringUtils.isNotEmpty(request.getFuncImage5())){
            updatePo.setFuncImage5(request.getFuncImage5());
        }

        if(StringUtils.isNotEmpty(request.getName())){
            updatePo.setName(request.getName());
        }

        if(StringUtils.isNotEmpty(request.getUrl())){
            updatePo.setUrl(request.getUrl());
        }
        updatePo.setAdminUrl(request.getAdminUrl());
        updatePo.setLastUpdateTime(System.currentTimeMillis());
        updatePo.setSort(request.getSort());
        updatePo.setMenuId(request.getMenuId());
        updatePo.setId(request.getId());
        return contentMapper.update(updatePo);

    }

    public Integer delete(Integer id) {
        return contentMapper.updateStatus(id);
    }
}
