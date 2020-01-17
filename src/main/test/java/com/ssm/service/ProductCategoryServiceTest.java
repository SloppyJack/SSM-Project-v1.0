package com.ssm.service;

import com.ssm.BaseTest;
import com.ssm.dto.Result;
import com.ssm.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.service
 * @date:2019/8/29
 **/
public class ProductCategoryServiceTest extends BaseTest {
    @Autowired
    private ProductCategoryService service;

    @Test
    public void testBatchAdd(){
        List list = new ArrayList();
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("测试3");
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(2L);
        productCategory.setWeight(5);
        list.add(productCategory);
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setProductCategoryName("测试4");
        productCategory1.setCreateTime(new Date());
        productCategory1.setShopId(2L);
        productCategory1.setWeight(7);
        list.add(productCategory1);
        Result result = service.batchAddProductCategory(list);
        assertEquals(101000,result.getRetCode());
    }
}
