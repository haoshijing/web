package com.hubei.web.admin.controller.response;

import lombok.Data;

@Data
public class ContentVo {
    private String name;
    private String image;
    private String url;
    private String menuName;
    private Integer menuId;
    private Long createTime;
    private Integer id;
    private Integer sort;
    private Integer webPrice;
}
