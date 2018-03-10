package com.hubei.base.test;

import com.hubei.base.mapper.impl.ContentMapper;
import com.hubei.base.mapper.impl.MenuMapper;
import com.hubei.base.po.ContentPo;
import com.hubei.base.po.MenuPo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class MapperTest {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    ContentMapper contentMapper;

    @Test
    public void testInsertMenu(){
        MenuPo menuPo = new MenuPo();
        menuPo.setMenuName("测试菜单");
        menuPo.setParentId(0);
        Assert.assertTrue(menuMapper.insert(menuPo) > 0);
    }

    @Test
    public void testInsertContent(){
        ContentPo contentPo = new ContentPo();
        contentPo.setUrl("http:/xxxxx");
        contentPo.setMenuId(1);
        contentPo.setName("希尔顿SB平台12221");
        Assert.assertTrue(contentMapper.insert(contentPo) > 0);
        ContentPo queryPo = new ContentPo();
        queryPo.setName("希尔顿");
        List<ContentPo> queryPos = contentMapper.selectList(queryPo);

        for(ContentPo queryPo2 : queryPos){
            System.out.println(queryPo2.getName());
        }
    }

}
