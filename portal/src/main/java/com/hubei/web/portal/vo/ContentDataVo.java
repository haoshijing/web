package com.hubei.web.portal.vo;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class ContentDataVo {
    private List<MenuVo> parentMenus;
    private List<ContentListVo> contentListVos;

    @Data
    public static class ContentListVo{
        private List<ContentVo> contentVos;
        private String menuName;
    }

    @Data
    public static class ContentVo{
        private Integer id;
        private String name;
        private String url;
        private String link;
        private Integer webPrice;
    }
    @Data
    public static class MenuVo{
        private Integer menuId;
        private String menuName;
        private List<MenuVo> subMenuList  = Lists.newArrayList();;
    }
}
