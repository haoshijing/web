package com.hubei.web.portal.service;

import com.hubei.base.mapper.impl.ContentMapper;
import com.hubei.base.mapper.impl.MenuMapper;
import com.hubei.base.po.ContentPo;
import com.hubei.base.po.MenuPo;
import com.hubei.web.portal.vo.ContentDataVo;
import com.hubei.web.portal.vo.ContentDetailVo;
import com.hubei.web.portal.vo.MoreContentDataVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IndexService {

    @Autowired
    MenuMapper menuMapper;

    @Value("${imageHost}")
    private String imageHost;

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

        if (menuPoList.size() > 0) {
            int index = 0;
            if (menuId != null) {
                for (ContentDataVo.MenuVo menuVo : parentMenus) {
                    if (menuVo.getMenuId().equals(menuId)) {
                        break;
                    }
                    index++;
                }
            }
            ContentDataVo.MenuVo indexVo = parentMenus.get(index);
            List<ContentDataVo.MenuVo> subMenuVos = indexVo.getSubMenuList();
            List<ContentDataVo.ContentListVo> contentListVos = obtainContentVoList(subMenuVos);
            contentDataVo.setContentListVos(contentListVos);
        }

        return contentDataVo;
    }

    private List<ContentDataVo.ContentListVo> obtainContentVoList(List<ContentDataVo.MenuVo> subMenuVos) {
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
                                BeanUtils.copyProperties(contentPo, contentVo);
                                StringBuilder sb = new StringBuilder();
                                sb.append(imageHost).append("/").append(contentPo.getImage());
                                contentVo.setImage(sb.toString());
                                return contentVo;
                            }
                    ).collect(Collectors.toList());
                    contentListVo.setContentVos(contentVos);
                    return contentListVo;
                }).collect(Collectors.toList());
        return contentListVos;

    }

    public MoreContentDataVo more(Integer menuId) {
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
        MoreContentDataVo moreContentDataVo = new MoreContentDataVo();
        moreContentDataVo.setParentMenus(parentMenus);

        ContentPo queryContentPo = new ContentPo();
        queryContentPo.setMenuId(menuId);
        queryContentPo.setLimit(100);

        List<ContentPo> contentPos = contentMapper.selectList(queryContentPo);

        List<ContentDataVo.ContentVo> contentVos = contentPos.stream().map(
                contentPo -> {
                    ContentDataVo.ContentVo contentVo = new ContentDataVo.ContentVo();
                    BeanUtils.copyProperties(contentPo, contentVo);
                    StringBuilder sb = new StringBuilder();
                    sb.append(imageHost).append("/").append(contentPo.getImage());
                    contentVo.setImage(sb.toString());
                    return contentVo;
                }
        ).collect(Collectors.toList());
        moreContentDataVo.setContentVos(contentVos);
        return moreContentDataVo;
    }

    public ContentDetailVo contentDetail(Integer id) {
        ContentDetailVo contentDetailVo = new ContentDetailVo();
        ContentPo contentPo = contentMapper.selectById(id);
        BeanUtils.copyProperties(contentPo,contentDetailVo);
        return contentDetailVo;
    }
}
