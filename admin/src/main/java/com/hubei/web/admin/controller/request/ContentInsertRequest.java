package com.hubei.web.admin.controller.request;

import lombok.Data;

@Data

public class ContentInsertRequest {
    private String name;
    private Integer sort;
    private String image;
    private String url;
    private Integer menuId;
    private Integer id;
    private String detailImage1;
    private String detailImage2;
    private String detailImage3;
    private String detailImage5;
    private String detailImage4;
    private String funcImage1;
    private String funcImage2;
    private String funcImage3;
    private String funcImage4;
    private String funcImage5;
}
