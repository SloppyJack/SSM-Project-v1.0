package com.ssm.dao;

import com.ssm.BaseTest;
import com.ssm.entity.Product;
import com.ssm.entity.ProductCategory;
import com.ssm.entity.ProductImg;
import com.ssm.entity.Shop;
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
public class ProductDaoTest extends BaseTest {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testAInsertProduct(){
        Shop shop1 = new Shop();
        shop1.setShopId(1L);
        ProductCategory pc1 = new ProductCategory();
        pc1.setProductCategoryId(1L);
        //初始化三个商品实例并添加进shopId为1的店里
        //同时商品类别Id也为1
        Product product1 = new Product();
        product1.setProductName("测试1");
        product1.setProductDesc("测试描述1");
        product1.setImgAddr("test1");
        product1.setWeight(1);
        product1.setStatus(1);
        product1.setCreateTime(new Date());
        product1.setLastEditTime(new Date());
        product1.setShop(shop1);
        product1.setProductCategory(pc1);
        Product product2 = new Product();
        product2.setProductName("测试2");
        product2.setProductDesc("测试描述2");
        product2.setImgAddr("test2");
        product2.setWeight(1);
        product2.setStatus(1);
        product2.setCreateTime(new Date());
        product2.setLastEditTime(new Date());
        product2.setShop(shop1);
        product2.setProductCategory(pc1);
        Product product3 = new Product();
        product3.setProductName("测试3");
        product3.setProductDesc("测试描述3");
        product3.setImgAddr("test3");
        product3.setWeight(1);
        product3.setStatus(1);
        product3.setCreateTime(new Date());
        product3.setLastEditTime(new Date());
        product3.setShop(shop1);
        product3.setProductCategory(pc1);
        //判断是否添加成功
        int temp1 = productDao.insertProduct(product1);
        assertEquals(1,temp1);
        int temp2 = productDao.insertProduct(product1);
        assertEquals(1,temp2);
        int temp3= productDao.insertProduct(product1);
        assertEquals(1,temp3);
    }

    @Test
    public void testQueryProductByProductId(){
        long productId = 2L;
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("图片1");
        productImg1.setImgDesc("测试图片1");
        productImg1.setWeight(1);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(productId);
        //第二个商品图片类
        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("图片2");
        productImg2.setImgDesc("测试图片2");
        productImg2.setWeight(1);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(productId);
        List<ProductImg> productImgList = new ArrayList<>();
        productImgList.add(productImg1);
        productImgList.add(productImg2);
        int temp = productDao.queryProductById(productId).getProductImgList().size();
        assertEquals(4,temp);

    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        ProductCategory pc = new ProductCategory();
        Shop shop = new Shop();
        shop.setShopId(1L);
        pc.setProductCategoryId(1L);
        product.setProductId(3L);
        product.setShop(shop);
        product.setProductCategory(pc);
        product.setProductName("测试产品3");
        int temp = productDao.updateProduct(product);
        assertEquals(1,temp);
    }

    @Test
    public void testQueryProductList(){
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        product.setShop(shop);
        List<Product> productList = productDao.queryProductList(product,0,10);
        assertEquals(7,productList.size());
    }

    @Test
    public void testQueryProductCount(){
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        product.setShop(shop);
        int temp = productDao.queryProductCount(product);
        assertEquals(2,temp);

    }
}
