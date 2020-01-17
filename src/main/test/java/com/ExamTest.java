package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: PACKAGE_NAME
 * @date:2020/1/5
 **/
public class ExamTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //新建列表
        List<String> strList = new ArrayList();
        //循环读入控制台输入的8个字符串，并添加到List中
        for (int i=0 ; i<1 ; i++){
            String temp = scanner.nextLine();
            if (temp.trim().length() != 8){
                i --;
                System.out.println("车牌号长度为8，请重新输入：");
            }else if (!judgeStrFormat(temp)){
                i --;
                System.out.println("此车牌号只能是大写字母或数字，请重新输入：");
            }
            else {
                strList.add(temp);
            }
        }

        String result = findSpecificStr(strList);
        //如果返回的结果中没有字符串，则代表没有找到
        if ("".equals(result)){
            System.out.println("Not found");
        }else {
            System.out.println("找到的车牌号为："+result);
        }
    }

    /**
     * 找到指定的字符串，并返回
     * @param strings
     * @return
     */
    private static String findSpecificStr(List<String> strings) {
        for (int i = 0 ; i<strings.size() ; i++){
            String temp = strings.get(i);
            //不包含4和S
            if (!temp.contains("4") && !temp.contains("S")){
                return temp;
            }
        }
        return "";
    }

    /**
     * 判断字符串的格式是否合规
     * @param str
     * @return
     */
    private static boolean judgeStrFormat(String str){
        boolean isCapital = true;   //表示是否为大写字母
        boolean isNumber = true;
        for (int i=0 ; i<str.length() ; i++){
            final String number = "0123456789";
            //判断每一个字符是否为大写字母或数字
            if(!(str.charAt(i)>='A' && str.charAt(i)<='Z'))
            {
                isCapital = false;
            }
            if (number.indexOf(str.charAt(i)) == -1){
                isNumber = false;
            }
        }
        //只要任一为true，则返回true
        return isCapital || isNumber;
    }

}
