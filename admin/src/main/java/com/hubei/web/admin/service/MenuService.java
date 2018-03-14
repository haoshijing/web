package com.hubei.web.admin.service;

import com.hubei.base.enums.Status;
import com.hubei.base.mapper.impl.MenuMapper;
import com.hubei.base.po.ContentPo;
import com.hubei.base.po.MenuPo;
import com.hubei.web.admin.controller.request.MenuInsertRequest;
import com.hubei.web.admin.controller.request.MenuQueryVo;
import com.hubei.web.admin.controller.response.MenuVo;
import com.hubei.web.admin.controller.response.ParentMenuVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.hubei.base.constants.RetCode.LIMIT;

@Repository
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public List<MenuVo> selectList(MenuQueryVo contentQueryVo){
        Integer page = contentQueryVo.getPage();
        if(page == 0){
            page = 1;
        }
        Integer offset = (page - 1) * LIMIT;
        MenuPo queryPo = new MenuPo();
        queryPo.setOffset(offset);
        queryPo.setMenuName(contentQueryVo.getMenuName());

        List<MenuPo> menuPos = menuMapper.selectList(queryPo);
        return menuPos.stream().map(menuPo -> {
            MenuVo menuVo = new MenuVo();
            BeanUtils.copyProperties(menuPo,menuVo);
            if(menuPo.getParentId() != null){
                MenuPo dbMenuPo = menuMapper.selectById(menuPo.getParentId());
                if(dbMenuPo != null){
                    menuVo.setMenuParentName(dbMenuPo.getMenuName());
                }
            }
            return  menuVo;
        }).collect(Collectors.toList());
    }

    public Integer selectCount(MenuQueryVo menuQueryVo) {
        MenuPo queryPo = new MenuPo();
        queryPo.setMenuName(menuQueryVo.getMenuName());
        return menuMapper.selectCount(queryPo);
    }

    public Integer insertMenu(MenuInsertRequest request) {
        MenuPo menuPo = new MenuPo();
        menuPo.setMenuName(request.getMenuName());
        menuPo.setSort(request.getSort());
        if(request.getParentId() == null){
            menuPo.setParentId(0);
        }else{
            menuPo.setParentId(request.getParentId());
        }
        menuPo.setLastUpdateTime(System.currentTimeMillis());
        menuPo.setInsertTime(System.currentTimeMillis());
        menuPo.setStatus(Status.OK.getCode());
        menuMapper.insert(menuPo);
        return 0;
    }

    public List<ParentMenuVo> queryParentMenus() {
        MenuPo menuPo = new MenuPo();
        menuPo.setParentId(0);
        List<ParentMenuVo> parentMenuVos =  menuMapper.selectList(menuPo).
                stream().map(menuPo1 -> {
                    ParentMenuVo parentMenuVo = new ParentMenuVo();
                    BeanUtils.copyProperties(menuPo1,parentMenuVo);
                    return parentMenuVo;
        }).collect(Collectors.toList());
        return  parentMenuVos;
    }
}
