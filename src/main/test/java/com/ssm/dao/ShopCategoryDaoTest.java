package com.ssm.dao;

import com.ssm.BaseTest;
import com.ssm.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.dao
 * @date:2019/8/5
 **/
public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void testQuery(){
       /* List<ShopCategory> list = shopCategoryDao.queryShopCategory(new ShopCategory());
        assertEquals(2,list.size());*/
        /*ShopCategory shopCategory = new ShopCategory();
        ShopCategory shopCategory1 = new ShopCategory();
        shopCategory1.setShopCategoryId(1L);
        shopCategory.setParent(shopCategory1 );
        System.out.println(shopCategory.getParent().getShopCategoryId());*/
        List<ShopCategory> list = shopCategoryDao.queryShopCategory(null);
        assertEquals("焦糖咖啡",list.get(0).getShopCategoryName());
    }

}
