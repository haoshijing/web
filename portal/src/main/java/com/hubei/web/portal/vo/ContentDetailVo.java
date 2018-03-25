package com.hubei.web.portal.vo;

import lombok.Data;

@Data
public class ContentDetailVo {
    private String url;
    private String image;
    private Integer status;
    private String adminUrl;
    /**
     * 网站名称
     */
    private String name;

}
