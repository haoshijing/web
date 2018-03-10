package com.hubei.base.mapper.impl;

import com.hubei.base.mapper.BaseMapper;
import com.hubei.base.po.AdminPo;

public interface AdminMapper extends BaseMapper<AdminPo> {
    AdminPo selectByUsername(String userName);
}
