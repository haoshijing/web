package com.hubei.base.mapper;

import java.util.List;

public interface BaseMapper<T> {
    int insert(T bean);

    int update(T bean);

    List<T> selectList(T data);

    Integer selectCount(T data);

    T selectById(Integer id);
}
