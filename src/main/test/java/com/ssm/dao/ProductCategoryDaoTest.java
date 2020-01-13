package com.ssm.dao;

import com.ssm.BaseTest;
import com.ssm.entity.ProductCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.dao
 * @date:2019/8/28
 **/
public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    private ProductCategoryDao dao;

    @Test
    public void testDelete(){
        int temp = dao.deleteProductCategory(25L,1L);
        assertEquals(1,temp);
    }

    @Test
    @Ignore
    public void testBatchInsertProductCategory(){
        List list = new ArrayList();
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("测试1");
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(1L);
        productCategory.setWeight(10);
        list.add(productCategory);
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setProductCategoryName("测试2");
        productCategory1.setCreateTime(new Date());
        productCategory1.setShopId(1L);
        productCategory1.setWeight(20);
        list.add(productCategory1);
        assertEquals(2,dao.batchInsertProductCategory(list));
    }

    @Test
    @Ignore
    public void testQuery(){
        long shopId = 1l;
        List<ProductCategory> list = dao.queryProductCategoryList(shopId);
        assertEquals(3,list.size());
    }
}
