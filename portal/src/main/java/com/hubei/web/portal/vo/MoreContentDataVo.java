package com.hubei.web.portal.vo;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class MoreContentDataVo {
    private List<ContentDataVo.MenuVo> parentMenus;
    private List<ContentDataVo.ContentVo> contentVos;


    @Data
    public static class ContentVo{
        private Integer id;
        private String name;
        private String url;
        private String image;
        private Integer webPrice;
    }
    @Data
    public static class MenuVo{
        private Integer menuId;
        private String menuName;
        private List<ContentDataVo.MenuVo> subMenuList  = Lists.newArrayList();;
    }
}
