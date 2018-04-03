package com.hubei.web.admin.controller;
import com.hubei.base.ApiResponse;
import com.hubei.base.mapper.impl.ContentMapper;
import com.hubei.base.mapper.impl.MenuMapper;
import com.hubei.base.po.ContentPo;
import com.hubei.base.po.MenuPo;
import com.hubei.web.admin.controller.request.ContentInsertRequest;
import com.hubei.web.admin.controller.request.ContentQueryVo;
import com.hubei.web.admin.controller.response.ContentVo;
import com.hubei.web.admin.service.ContentService;
import com.hubei.web.admin.util.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Value("${imageHost}")
    private String imageHost;

    @Value("${filePath}")
    private String filePath;
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private ContentService contentService;
    @RequestMapping("/selectList")
    public ApiResponse<List<ContentVo>> queryList(@RequestBody ContentQueryVo contentQueryVo){
        Integer page = contentQueryVo.getPage();
        String name = contentQueryVo.getName();
        if(page == 0){
            page = 1;
        }
        Integer offset = (page-1)*50;
        ContentPo queryPo = new ContentPo();
        queryPo.setOffset(offset);
        queryPo.setName(name);
        List<ContentPo> contentPos = contentMapper.selectList(queryPo);
        List<ContentVo> contentVos = contentPos.stream().map(contentPo -> {
            ContentVo contentVo = new ContentVo();

            contentVo.setImage(buildImage(contentPo.getImage()));
            contentVo.setDetailImage2(buildImage(contentPo.getDetailImage2()));
            contentVo.setDetailImage3(buildImage(contentPo.getDetailImage3()));
            contentVo.setDetailImage4(buildImage(contentPo.getDetailImage4()));
            contentVo.setDetailImage5(buildImage(contentPo.getDetailImage5()));
            contentVo.setFuncImage1(buildImage(contentPo.getFuncImage1()));
            contentVo.setFuncImage2(buildImage(contentPo.getFuncImage2()));
            contentVo.setFuncImage3(buildImage(contentPo.getFuncImage3()));
            contentVo.setFuncImage4(buildImage(contentPo.getFuncImage4()));
            contentVo.setFuncImage5(buildImage(contentPo.getFuncImage5()));
            contentVo.setAdminUrl(contentPo.getAdminUrl());

            MenuPo menuPo =menuMapper.selectById(contentPo.getMenuId());
            if(menuPo != null){
                contentVo.setMenuName(menuPo.getMenuName());
            }
            contentVo.setMenuId(contentPo.getMenuId());
            contentVo.setUrl(contentPo.getUrl());
            contentVo.setName(contentPo.getName());
            contentVo.setId(contentPo.getId());
            contentVo.setSort(contentPo.getSort());
            return  contentVo;
        }).collect(Collectors.toList());
        return new ApiResponse<>(contentVos);
    }

    @RequestMapping("/selectCount")
    public ApiResponse<Integer> selectCount(@RequestBody ContentQueryVo contentQueryVo){
        ContentPo queryPo = new ContentPo();
        String name = contentQueryVo.getName();
        queryPo.setName(name);
        Integer count = contentMapper.selectCount(queryPo);
        return new ApiResponse<>(count);
    }

    @RequestMapping("/insertContent")
    public ApiResponse<Integer> insertContent(@RequestBody ContentInsertRequest request){
        Integer count = contentService.insert(request);
        return new ApiResponse<>(count);
    }

    @RequestMapping("/updateContent")
    public ApiResponse<Integer> updateContent(@RequestBody ContentInsertRequest request){
        Integer count = contentService.update(request);
        return new ApiResponse<>(count);
    }

    @RequestMapping("/deleteContent/{id}")
    public ApiResponse<Integer> updateContent(@PathVariable String id){
        Integer count = contentService.delete(Integer.valueOf(id));
        return new ApiResponse<>(count);
    }


    @RequestMapping("/upload")
    public ApiResponse<String> uploadImage(MultipartFile image){
        String fileName = image.getOriginalFilename();
        int suffixIdx = fileName.lastIndexOf(".");
        String fileSuffix = fileName.substring(suffixIdx+1);
        String uuidName = UUID.randomUUID().toString().replace("-","");
        String newFileName = new StringBuilder(uuidName).append(".").append(fileSuffix).toString();
       try {
           FileUtil.uploadFile(image.getBytes(), filePath, newFileName);
       }catch (Exception e){

       }
        return new ApiResponse<>(newFileName);
    }


    @RequestMapping("/uploadFuncImage5")
    public ApiResponse<String> uploadFuncImage5(MultipartFile funcImage5){
       return doUpdateImage(funcImage5);
    }
    @RequestMapping("/uploadFuncImage4")
    public ApiResponse<String> uploadFuncImage4(MultipartFile funcImage4){
        return doUpdateImage(funcImage4);
    }
    @RequestMapping("/uploadFuncImage3")
    public ApiResponse<String> uploadFuncImage3(MultipartFile funcImage3){
        return doUpdateImage(funcImage3);
    }
    @RequestMapping("/uploadFuncImage2")
    public ApiResponse<String> uploadFuncImage2(MultipartFile funcImage2){
        return doUpdateImage(funcImage2);
    }
    @RequestMapping("/uploadFuncImage1")
    public ApiResponse<String> uploadFuncImage1(MultipartFile funcImage1){
        return doUpdateImage(funcImage1);
    }

    @RequestMapping("/uploadDetailImage1")
    public ApiResponse<String> uploadDetailImage1(MultipartFile detailImage1){
        return doUpdateImage(detailImage1);
    }
    @RequestMapping("/uploadDetailImage2")
    public ApiResponse<String> uploadDetailImage2(MultipartFile detailImage2){
        return doUpdateImage(detailImage2);
    }
    @RequestMapping("/uploadDetailImage3")
    public ApiResponse<String> uploadDetailImage3(MultipartFile detailImage3){
        return doUpdateImage(detailImage3);
    }
    @RequestMapping("/uploadDetailImage4")
    public ApiResponse<String> uploadDetailImage4(MultipartFile detailImage4){
        return doUpdateImage(detailImage4);
    }
    @RequestMapping("/uploadDetailImage5")
    public ApiResponse<String> uploadDetailImage5(MultipartFile detailImage5){
        return doUpdateImage(detailImage5);
    }



    private ApiResponse<String> doUpdateImage(MultipartFile image){
        String fileName = image.getOriginalFilename();
        int suffixIdx = fileName.lastIndexOf(".");
        String fileSuffix = fileName.substring(suffixIdx+1);
        String uuidName = UUID.randomUUID().toString().replace("-","");
        String newFileName = new StringBuilder(uuidName).append(".").append(fileSuffix).toString();
        try {
            FileUtil.uploadFile(image.getBytes(), filePath, newFileName);
        }catch (Exception e){

        }
        return new ApiResponse<>(newFileName);
    }

    private String buildImage(String image){
        if(StringUtils.isNotEmpty(image)) {
            StringBuilder sb = new StringBuilder();
            sb.append(imageHost).append("/").append(image);
            return sb.toString();
        }
        return "";
    }
}
