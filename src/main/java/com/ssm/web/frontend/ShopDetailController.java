package com.ssm.web.frontend;

import com.ssm.dto.CodeMsg;
import com.ssm.dto.ProductExecution;
import com.ssm.dto.Result;
import com.ssm.entity.Product;
import com.ssm.entity.ProductCategory;
import com.ssm.entity.Shop;
import com.ssm.service.ProductCategoryService;
import com.ssm.service.ProductService;
import com.ssm.service.ShopCategoryService;
import com.ssm.service.ShopService;
import com.ssm.util.HttpServletRequestUtil;
import com.ssm.web.shopadmin.ProductManagementController;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.web.frontend
 * @date: 2020/1/15 20:16
 **/
@Controller
@RequestMapping("/frontend")
public class ShopDetailController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductService productService;

    /**
     * 根据shopId列出店铺详情信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "listShopDetailPageInfo",method = RequestMethod.GET)
    @ResponseBody
    private Result listShopDetailPageInfo(HttpServletRequest request, HttpServletResponse response){
        long shopId = HttpServletRequestUtil.getLong(request,"shopId");
        if (shopId != -1){
            Map<String,Object> modelMap = new HashMap<>();
            //获取店铺Id为shopId的店铺
            Shop shop = shopService.getByShopId(shopId);
            //获取店铺商铺类别列表
            List<ProductCategory> productCategoryList = productCategoryService.getProductCategoryList(shopId);
            modelMap.put("shop",shop);
            modelMap.put("productCategoryList",productCategoryList);
            return Result.success(modelMap);
        }else {
            return Result.error(CodeMsg.NULL_SHOP_ID);
        }
    }

    /**
     * 根据查询条件分页列出该店铺下的所有商品
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/listProductsByShop",method = RequestMethod.GET)
    @ResponseBody
    private Result listProductsByShop(HttpServletRequest request,HttpServletResponse response){
        //获取页码及大小
        int pageIndex = HttpServletRequestUtil.getInt(request,"pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request,"pageSize");
        long shopId = HttpServletRequestUtil.getLong(request,"shopId");
        if (pageIndex > -1 && pageSize > -1 && shopId > -1){
            Map<String,Object> modelMap = new HashMap<>();
            //获取商品类别Id
            long productCategoryId = HttpServletRequestUtil.getLong(request,"productCategoryId");
            //获取商品名（模糊查找）
            String productName = HttpServletRequestUtil.getString(request,"productName");
            //组合查询条件
            Product productCodition = ProductManagementController.compactProductCondition(shopId,productCategoryId,productName);
            ProductExecution pe = productService.getProductList(productCodition,pageIndex,pageSize);
            modelMap.put("productList",pe.getProductList());
            modelMap.put("count",pe.getCount());
            return Result.success(modelMap);
        }else {
            if (pageIndex <= -1 && pageSize <= -1)
                return Result.error(CodeMsg.EMPTY_PAGESIZE_OR_PAGEINDEX);
            else
                return Result.error(CodeMsg.NULL_SHOP_ID);
        }
    }
}
