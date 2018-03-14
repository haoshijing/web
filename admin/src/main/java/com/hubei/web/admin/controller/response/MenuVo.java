package com.hubei.web.admin.controller.response;

import lombok.Data;

@Data
public class MenuVo {
    private String menuName;
    private String menuParentName;
    private Integer id;
    private Integer status;
    private Integer parentId;
    private Integer sort;
    /**
     * 子菜单个数
     */
    private Integer subMenuCount;
}
