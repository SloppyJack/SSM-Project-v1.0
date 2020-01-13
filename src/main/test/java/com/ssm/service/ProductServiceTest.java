package com.ssm.service;

import com.ssm.BaseTest;
import com.ssm.dto.CodeMsg;
import com.ssm.dto.ImageHolder;
import com.ssm.dto.ProductExecution;
import com.ssm.entity.Product;
import com.ssm.entity.ProductCategory;
import com.ssm.entity.Shop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.service
 * @date:2019/10/9
 **/
public class ProductServiceTest  extends BaseTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testAddProduct() throws FileNotFoundException {
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(1L);
        product.setShop(shop);
        product.setProductCategory(productCategory);
        product.setProductName("测试商品1");
        product.setProductDesc("测试商品描述1");
        product.setWeight(20);
        product.setCreateTime(new Date());
        product.setStatus(CodeMsg.PRODUCT_STATUS_ONLINE.getRetCode());
        //创建缩略图文件流
        File thumbnailFile = new File("C:\\Users\\Bin\\Desktop\\work\\Pictrues\\caixukun.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(is,thumbnailFile.getName());
        //创建两个商品详情图文件流并将它们添加到详情图列表中
        File productImg1 = new File("C:\\Users\\Bin\\Desktop\\work\\Pictrues\\13.jpg");
        InputStream is1 = new FileInputStream(productImg1);
        File productImg2 = new File("C:\\Users\\Bin\\Desktop\\work\\Pictrues\\15.jpg");
        InputStream is2 = new FileInputStream(productImg2);
        List<ImageHolder> imageHolders = new ArrayList<>();
        imageHolders.add(new ImageHolder(is1,productImg1.getName()));
        imageHolders.add(new ImageHolder(is2,productImg2.getName()));
        //添加商品验证
        ProductExecution pe = productService.addProduct(product,thumbnail,imageHolders);
        assertEquals(CodeMsg.PRODUCT_STATUS_ONLINE.getRetCode(),pe.getState());
    }

    @Test
    public void testModifyProduct() throws FileNotFoundException {
        //创建shopId为1且productCategory为1的商品实例并给其他成员变量赋值
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1l);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(1L);
        product.setProductId(3l);
        product.setShop(shop);
        product.setProductCategory(productCategory);
        product.setProductName("这是商品3");
        product.setProductDesc("这是商品3的描述");
        //创建图片缩略图文件流
        File file = new File("C:\\Users\\Bin\\Desktop\\work\\Pictrues\\16.jpg");
        InputStream inputStream1 = new FileInputStream(file);
        ImageHolder imageHolder = new ImageHolder(inputStream1,file.getName());
        //创建两个商品详情图文件
        File productImg1 = new File("C:\\Users\\Bin\\Desktop\\work\\Pictrues\\17.jpg");
        InputStream is1 = new FileInputStream(productImg1);
        File productImg2 = new File("C:\\Users\\Bin\\Desktop\\work\\Pictrues\\18.jpg");
        InputStream is2 = new FileInputStream(productImg2);
        List<ImageHolder> imageHolders = new ArrayList<>();
        imageHolders.add(new ImageHolder(is1,productImg1.getName()));
        imageHolders.add(new ImageHolder(is2,productImg2.getName()));
        //修改商品并验证
        ProductExecution pe = productService.modifyProduct(product,imageHolder,imageHolders);
        assertEquals(CodeMsg.PRODUCT_UPDATE_SUCCESS.getRetCode(),pe.getState());
    }
}
