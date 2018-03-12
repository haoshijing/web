package com.hubei.web.admin.controller.request;

import lombok.Data;

@Data
public class MenuInsertRequest {
    private Integer parentId;
    private String menuName;
    private Integer sort;
}
