package com.xiaoyb.test;

import com.xiaoyb.controller.UserController;
import com.xiaoyb.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author XIAO
 * @since 2017-09-18 15:18
 **/
public class LogTest {
    @Test
    public void testAOP1() {
        //启动Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                new String[]{"classpath:application.xml", "classpath:springmvc.xml"});
        //获取service或controller组件
        UserController userController = (UserController) ctx.getBean("userController");
        userController.testAOP(new User());
    }
}
