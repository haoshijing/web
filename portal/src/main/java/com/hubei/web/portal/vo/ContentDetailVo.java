package com.hubei.web.portal.vo;

import lombok.Data;

@Data
public class ContentDetailVo {
    private String url;
    private String image;
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
    private Integer status;
    private String adminUrl;
    /**
     * 网站名称
     */
    private String name;

    private Integer id;
}
