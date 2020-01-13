package com.ssm.util;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm.util
 * @date:2019/7/25
 **/
public class PathUtil {
    //返回项目图片相对路径
    private static String  separator = System.getProperty("file.separator");
    //得到基础路径
    public static String getImageBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")){
            basePath = "D:/workspace/image/";
        }else{
            basePath = "/home/workspace/image/";
        }
        basePath = basePath.replace("/",separator);
       return  basePath;

    }

    //获取店铺图片基本路径
    public static String getShopImagePath(long shopId){
        String imagePath = "upload/item/shop"+shopId+"/";
        return imagePath.replace("/",separator);
    }
}
