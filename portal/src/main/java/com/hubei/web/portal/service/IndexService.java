package com.hubei.web.portal.service;

import com.hubei.web.portal.vo.ContentDataVo;
import org.springframework.stereotype.Repository;

@Repository
public class IndexService {
    public ContentDataVo obtainIndexData() {
        ContentDataVo contentDataVo = new ContentDataVo();
        return contentDataVo;
    }
}
