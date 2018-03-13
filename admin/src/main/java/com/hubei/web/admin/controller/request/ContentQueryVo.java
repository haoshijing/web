package com.hubei.web.admin.controller.request;

import lombok.Data;

@Data
public class ContentQueryVo {
    private String name;
    private Integer page;
    private Integer menuId;
}
