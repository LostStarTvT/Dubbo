package com.dubbo.provider.App;

import com.dubbo.provider.annotation.DubboConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @Classname AppAnnotationServer
 * @Description TODO 使用注解的启动类。
 * @Date 2020/7/8 14:53
 * @Created by Seven
 */
public class AppAnnotationServer {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DubboConfiguration.class);
        applicationContext.start();
        System.in.read();
    }
}
