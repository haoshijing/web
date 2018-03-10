package com.hubei.base.po;

import lombok.Data;

@Data
public class MenuPo extends BaseQueryPo {
    private Integer id;
    private String menuName;
    private Integer parentId;
    private Integer sort;
    private Integer status;
    private Long insertTime;
    private Long lastUpdateTime;
}
