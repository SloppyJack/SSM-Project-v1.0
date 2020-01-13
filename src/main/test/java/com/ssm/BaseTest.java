package com.ssm;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: PACKAGE_NAME 初始化spring配置和junit
 * @date:2019/7/24
 **/
@RunWith(SpringJUnit4ClassRunner.class)
//告诉Junit需要加载Spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {

}
