package com.hubei.web.portal.vo;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class ContentDataVo {

    @Data
    public static class ContentVo{
        private Integer id;
        private String name;
        private String url;
        private String link;
    }
    @Data
    public static class MenuVo{
        private Integer menuId;
        private String menuName;
        private List<ContentVo> contentVos = Lists.newArrayList();
        private List<MenuVo> subMenuList  = Lists.newArrayList();;
    }
}
