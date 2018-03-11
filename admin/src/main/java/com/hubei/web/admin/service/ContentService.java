package com.hubei.web.admin.service;

import com.hubei.base.mapper.impl.ContentMapper;
import com.hubei.web.admin.controller.request.ContentInsertRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContentService {
    @Autowired
    ContentMapper contentMapper;
    public Integer insert(ContentInsertRequest request) {
        Integer ret = 0;
        return ret;
    }
}
