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
    private String adminUrl;
    private String detailImage1;
    private String detailImage2;
    private String detailImage3;
    private String detailImage4;
    private String detailImage5;
    private String funcImage1;
    private String funcImage2;
    private String funcImage3;
    private String funcImage4;
    private String funcImage5;
    private Integer sort = 0;
    /**
     * 网站名称
     */
    private String name;
}
