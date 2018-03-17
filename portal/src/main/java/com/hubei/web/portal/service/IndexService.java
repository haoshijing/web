package com.hubei.web.portal.service;

import com.hubei.base.mapper.impl.ContentMapper;
import com.hubei.base.mapper.impl.MenuMapper;
import com.hubei.base.po.ContentPo;
import com.hubei.base.po.MenuPo;
import com.hubei.web.portal.vo.ContentDataVo;
import org.springframework.beans.BeanUtils;
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
    public ContentDataVo obtainIndexData(Integer menuId) {
        MenuPo queryMenuPo = new MenuPo();
        queryMenuPo.setParentId(0);

        List<MenuPo> menuPoList = menuMapper.selectList(queryMenuPo);
        List<ContentDataVo.MenuVo> parentMenus = menuPoList.stream().map(menuPo -> {
            ContentDataVo.MenuVo menuVo = new ContentDataVo.MenuVo();
            menuVo.setMenuName(menuPo.getMenuName());
            menuVo.setMenuId(menuPo.getId());

            MenuPo querySubMenuPo = new MenuPo();
            querySubMenuPo.setParentId(menuPo.getId());

            List<MenuPo> subMenuPos = menuMapper.selectList(querySubMenuPo);
            List<ContentDataVo.MenuVo> subMenuVos = subMenuPos.stream().map(
                    menuPo1 -> {
                        ContentDataVo.MenuVo subMenuVo = new ContentDataVo.MenuVo();
                        subMenuVo.setMenuId(menuPo1.getId());
                        subMenuVo.setMenuName(menuPo1.getMenuName());
                        return subMenuVo;
                    }
            ).collect(Collectors.toList());
            menuVo.setSubMenuList(subMenuVos);
            return menuVo;
        }).collect(Collectors.toList());
        ContentDataVo contentDataVo = new ContentDataVo();
        contentDataVo.setParentMenus(parentMenus);

        if(menuPoList.size() > 0) {
            int index  = 0;
            if(menuId != null){
                for(ContentDataVo.MenuVo menuVo: parentMenus){
                    if(menuVo.getMenuId().equals(menuId)){
                        break;
                    }
                    index++;
                }
            }
            ContentDataVo.MenuVo indexVo = parentMenus.get(0);
            List<ContentDataVo.MenuVo> subMenuVos = indexVo.getSubMenuList();
            List<ContentDataVo.ContentListVo> contentListVos =
                    subMenuVos.stream().map(subMenuVo -> {
                        ContentDataVo.ContentListVo contentListVo = new ContentDataVo.ContentListVo();
                        contentListVo.setMenuName(subMenuVo.getMenuName());
                        ContentPo queryContentPo = new ContentPo();
                        queryContentPo.setMenuId(subMenuVo.getMenuId());
                        queryContentPo.setLimit(10);
                        List<ContentPo> contentPos = contentMapper.selectList(queryContentPo);
                        List<ContentDataVo.ContentVo> contentVos = contentPos.stream().map(
                                contentPo -> {
                                    ContentDataVo.ContentVo contentVo = new ContentDataVo.ContentVo();
                                    BeanUtils.copyProperties(contentPo,contentVo);
                                    return contentVo;
                                }
                        ).collect(Collectors.toList());
                        contentListVo.setContentVos(contentVos);
                        return contentListVo;
                    }).collect(Collectors.toList());
            contentDataVo.setContentListVos(contentListVos);
        }

        return contentDataVo;
    }
}
