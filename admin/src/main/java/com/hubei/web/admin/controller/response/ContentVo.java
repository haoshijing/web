package com.hubei.web.admin.controller.response;

import lombok.Data;

@Data
public class ContentVo {
    private String name;
    private String image;
    private String url;
    private String menuName;
    private Long createTime;
}
