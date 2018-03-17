package com.hubei.base.po;

import lombok.Data;

@Data
public class ContentPo extends BaseQueryPo{
    private Integer id;
    private String url;
    private String image;
    private Integer menuId;
    private Integer status;
    private Long insertTime;
    private Long lastUpdateTime;
    private Integer webPrice;
    private Integer sort = 0;
    /**
     * 网站名称
     */
    private String name;
}
