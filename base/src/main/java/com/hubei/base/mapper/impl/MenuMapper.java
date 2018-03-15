package com.hubei.base.mapper.impl;

import com.hubei.base.mapper.BaseMapper;
import com.hubei.base.po.MenuPo;

import java.util.List;

public interface MenuMapper extends BaseMapper<MenuPo> {
    List<MenuPo> queryMenuListForContent();
}
