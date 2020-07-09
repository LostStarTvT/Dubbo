package com.dubbo.provider.App;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Classname App
 * @Description TODO 使用xml文件方式进行启动dubbo服务器。
 * @Date 2020/7/7 21:31
 * @Created by Seven
 */
public class AppServer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/provider.xml");
        context.start();
        System.in.read(); // 按任意键退出
    }
}
