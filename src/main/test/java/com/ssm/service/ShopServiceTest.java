package com.ssm.service;

import com.ssm.BaseTest;
import com.ssm.dto.CodeMsg;
import com.ssm.dto.ImageHolder;
import com.ssm.dto.ShopExecution;
import com.ssm.entity.Area;
import com.ssm.entity.PersonInfo;
import com.ssm.entity.Shop;
import com.ssm.entity.ShopCategory;
import com.ssm.exceptions.ShopOperationException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.service
 * @date:2019/7/25
 **/
public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testGetShopListOfPage(){
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        ShopExecution se = shopService.getShopListOfPage(shopCondition,2,3);
        System.out.println(se.getState());
        System.out.println(se.getShopList().size());
    }

    @Test
    public void testModifyShop() throws ShopOperationException,FileNotFoundException{
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("店铺1");
        File shopImg = new File("C:\\Users\\Bin\\Desktop\\work\\Pictrues\\shop1.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder(is,shopImg.getName());
        ShopExecution shopExecution = shopService.modifyShop(shop,imageHolder);
        System.out.println(shopExecution.getShop().getShopImg());

    }

    @Test
    public void testAddShop() throws FileNotFoundException {
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
        shop.setShopName("测试店铺20");
        shop.setShopDesc("这是一个奶茶店");
        shop.setShopAddr("test20");
        shop.setWeight(10);
        shop.setPhone("14564788989");
        shop.setCreateTime(new Date());
        shop.setStatus(CodeMsg.SHOP_STATUS_CHECK.getRetCode());
        shop.setAdvice("审核中");
        File fileImg = new File("C:\\Users\\Bin\\Desktop\\caixukun.jpg");
        InputStream is = new FileInputStream(fileImg);
        ImageHolder imageHolder = new ImageHolder(is,fileImg.getName());
        ShopExecution se = shopService.addShop(shop,imageHolder);
        assertEquals(CodeMsg.SHOP_STATUS_CHECK.getRetCode(),se.getState());
    }
}
