package com.hubei.web.admin.controller;

import com.hubei.base.ApiResponse;
import com.hubei.base.constants.RetCode;
import com.hubei.base.mapper.impl.ContentMapper;
import com.hubei.base.mapper.impl.MenuMapper;
import com.hubei.base.po.ContentPo;
import com.hubei.base.po.MenuPo;
import com.hubei.web.admin.controller.request.ContentQueryVo;
import com.hubei.web.admin.controller.request.MenuInsertRequest;
import com.hubei.web.admin.controller.request.MenuQueryVo;
import com.hubei.web.admin.controller.response.ContentMenuVo;
import com.hubei.web.admin.controller.response.MenuVo;
import com.hubei.web.admin.controller.response.ParentMenuVo;
import com.hubei.web.admin.service.MenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/menu")
@RestController
public class MenuController {

   @Autowired
    private MenuService menuService;
    @RequestMapping("/selectList")
    public ApiResponse<List<MenuVo>> selectList(@RequestBody MenuQueryVo menuQueryVo){
        if(!checkParamsValid(menuQueryVo)){
            return new ApiResponse<>(RetCode.PARAM_EROR,"参数有误");
        }
        List<MenuVo> menuPos = menuService.selectList(menuQueryVo);
        return new ApiResponse<>(menuPos);
    }

    @RequestMapping("/selectCount")
    public ApiResponse<Integer> selectCount(@RequestBody MenuQueryVo menuQueryVo){
        if(!checkParamsValid(menuQueryVo)){
            return new ApiResponse<>(RetCode.PARAM_EROR,"参数有误");
        }
        Integer count = menuService.selectCount(menuQueryVo);
        return new ApiResponse<>(count);
    }
    @RequestMapping("/queryParentMenu")
    public ApiResponse<List<ParentMenuVo>> queryParentMenu(){
        List<ParentMenuVo> menuPos = menuService.queryParentMenus();
        return  new ApiResponse<>(menuPos);
    }

    @RequestMapping("/queryMenuListForContent")
    public ApiResponse<List<ContentMenuVo>> queryMenuListForContent(){
        List<ContentMenuVo> menuPos = menuService.queryMenuListForContent();
        return  new ApiResponse<>(menuPos);
    }
    @RequestMapping("/insertMenu")
    public ApiResponse<Integer> insertMenu(@RequestBody MenuInsertRequest request){
        Integer result =  menuService.insertMenu(request);
        return new ApiResponse<>(result);
    }

    private boolean checkParamsValid(MenuQueryVo menuQueryVo){
        if(menuQueryVo.getPage() == null){
            return false;
        }
        return true;
    }
}
