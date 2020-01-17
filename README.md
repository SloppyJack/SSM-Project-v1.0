# SSM-Project-v1.0
Version 1.0 of this project uses SSM frame and SUI frontend frame,version 2.0 will be used later,and version 2.0 will be replaced with SpringBoot frame.This project is for learning and reference only. If you have any questions, please email me itsbintnt@163.com, Thank you for Baidu translation.



## 部署项目须知

1. 须更改jdbc.properties的配置

   ![image-20200117230241521](C:\Users\Bin\AppData\Roaming\Typora\typora-user-images\image-20200117230241521.png)

2. 可以运行项目中的sql文件以创建数据库结构

3. run即可





## 如果你想将项目部署在本地，则需要配置一下tomcat以及更改代码中的配置

1. 首先，找到Idea中tomcat的位置

   ![image-20200117225619687](C:\Users\Bin\AppData\Roaming\Typora\typora-user-images\image-20200117225619687.png)

- 然后更改conf文件夹下的server.xml，增加上下文映射

  ![image-20200117225800564](C:\Users\Bin\AppData\Roaming\Typora\typora-user-images\image-20200117225800564.png)

- 将ConfigureConstant中的此变量值改为true

  ![image-20200117232446135](C:\Users\Bin\AppData\Roaming\Typora\typora-user-images\image-20200117232446135.png)



## 如果想使用oss来存储项目，则需要如下配置

1. 需修改ConfigureConstant中相关的oss的配置

   ![image-20200117230603236](C:\Users\Bin\AppData\Roaming\Typora\typora-user-images\image-20200117230603236.png)