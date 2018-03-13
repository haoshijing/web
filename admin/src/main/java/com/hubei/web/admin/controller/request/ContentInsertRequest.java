package com.hubei.web.admin.controller.request;

import lombok.Data;

@Data

public class ContentInsertRequest {
    private String name;
    private Integer sort;
    private String image;
    private String url;
}
