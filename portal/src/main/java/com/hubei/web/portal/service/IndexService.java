package com.hubei.web.portal.service;

import com.hubei.base.mapper.impl.ContentMapper;
import com.hubei.base.mapper.impl.MenuMapper;
import com.hubei.base.po.MenuPo;
import com.hubei.web.portal.vo.ContentDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IndexService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    ContentMapper contentMapper;
    public ContentDataVo obtainIndexData() {
        MenuPo queryMenuPo = new MenuPo();
        queryMenuPo.setParentId(0);

        List<MenuPo> menuPoList = menuMapper.selectList(queryMenuPo);
        List<ContentDataVo.MenuVo> menuVos = menuPoList.stream().map(menuPo -> {
            ContentDataVo.MenuVo menuVo = new ContentDataVo.MenuVo();
            return menuVo;
        }).collect(Collectors.toList());
        ContentDataVo contentDataVo = new ContentDataVo();
        return contentDataVo;
    }
}
