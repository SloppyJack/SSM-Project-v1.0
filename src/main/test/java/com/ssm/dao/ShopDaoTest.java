package com.ssm.dao;

import com.ssm.BaseTest;
import com.ssm.entity.Area;
import com.ssm.entity.PersonInfo;
import com.ssm.entity.Shop;
import com.ssm.entity.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.dao
 * @date:2019/7/25
 **/
public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testQueryShopListByPage(){
        Shop shopCondition = new Shop();
        ShopCategory childCategory = new ShopCategory();
        ShopCategory parentCategory = new ShopCategory();
        parentCategory.setShopCategoryId(1L);
        childCategory.setParent(parentCategory);
        shopCondition.setShopCategory(childCategory);
        //PersonInfo owner = new PersonInfo();
        //owner.setUserId(1L);
        //shopCondition.setOwner(owner);
        List<Shop> list = shopDao.queryShopListOfPage(shopCondition,0,1);
        int temp = shopDao.queryShopCountByShopCondition(shopCondition);
        System.out.println("店铺大小："+list.size());
        System.out.println("列表总数："+temp);
    }

    @Test
    @Ignore
    public void testQueryByShopId(){
        long shopId = 1;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println(shop.getShopName());
        System.out.println(shop.getArea().getAreaName());
    }

    @Test
    @Ignore
    public void testInsertShop(){
        Shop shop = new Shop();
        PersonInfo personInfo = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        personInfo.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(personInfo);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("coco");
        shop.setShopDesc("这是一个奶茶店");
        shop.setShopAddr("某小区");
        shop.setPhone("234234");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setStatus(1);
        shop.setAdvice("审核中");
        shop.setWeight(1);
        int temp = shopDao.insertShop(shop);
        assertEquals(1,temp);
    }

    @Test
    @Ignore
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(2L);
        shop.setShopDesc("这不是一个奶茶店");
        shop.setShopAddr("芜湖某小区");
        int temp = shopDao.updateShop(shop);
        assertEquals(1,temp);
    }
}
