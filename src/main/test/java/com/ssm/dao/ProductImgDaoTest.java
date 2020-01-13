package com.ssm.dao;

import com.ssm.BaseTest;
import com.ssm.entity.ProductImg;
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
 * @date:2019/9/10
 **/
public class ProductImgDaoTest extends BaseTest {
    @Autowired
    private ProductImgDao dao;

    @Test
    public void testBatchInsertProductImg(){
        ProductImg productImg = new ProductImg();
        productImg.setCreateTime(new Date());
        productImg.setImgAddr("testUrl");
        productImg.setImgDesc("测试商品详情图3");
        productImg.setProductId(2L);
        productImg.setWeight(1);
        List<ProductImg> list = new ArrayList();
        list.add(productImg);
        productImg = new ProductImg();
        productImg.setCreateTime(new Date());
        productImg.setImgAddr("testUrl");
        productImg.setImgDesc("测试商品详情图4");
        productImg.setProductId(2L);
        productImg.setWeight(2);
        list.add(productImg);
        int temp = dao.batchInsertProductImg(list);
        assertEquals(2,temp);
    }

    @Test
    public void testDeleteProductImgByProductId(){
        //删除商品
        long productId = 7L;
        int temp = dao.deleteProductImgByProductId(productId);
        assertEquals(1,temp);
    }
}
